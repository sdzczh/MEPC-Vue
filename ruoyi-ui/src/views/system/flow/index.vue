<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="ID" prop="id">
        <el-input
          v-model="queryParams.id"
          placeholder="请输入ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="phone">
        <el-input
          v-model="queryParams.phone"
          placeholder="请输入用户手机号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="操作类型" prop="operType">
        <el-input
          v-model="queryParams.operType"
          placeholder="请输入操作类型"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资金流向" prop="flows">
        <el-select v-model="queryParams.flows" placeholder="请选择资金流向" clearable size="small">
          <el-option
            v-for="dict in flowsOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="账户类型" prop="accountType">
        <el-select v-model="queryParams.accountType" placeholder="请选择账户类型" clearable size="small">
          <el-option
            v-for="dict in accountTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="币种" prop="coinType">
        <el-select v-model="queryParams.coinType" placeholder="请选择币种" clearable size="small">
          <el-option
            v-for="dict in coinTypeOptions"
            :key="dict.dictValue"
            :label="dict.dictLabel"
            :value="dict.dictValue"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:flow:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:flow:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:flow:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:flow:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="flowList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="用户手机号" align="center" prop="phone" />
      <el-table-column label="操作类型" align="center" prop="oper_type" />
      <el-table-column label="关联id" align="center" prop="relate_id" />
      <el-table-column label="资金流向" align="center" prop="flows" :formatter="flowsFormat" />
      <el-table-column label="账户类型" align="center" prop="accountType" :formatter="accountTypeFormat" />
      <el-table-column label="币种" align="center" prop="coinType" :formatter="coinTypeFormat" />
      <el-table-column label="操作人id" align="center" prop="oper_id" />
      <el-table-column label="金额" align="center" prop="amount" />
      <el-table-column label="操作后金额" align="center" prop="result_amount" />
      <el-table-column label="创建时间" align="center" prop="create_time" width="180">
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:flow:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:flow:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改流水记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="操作类型" prop="operType">
          <el-input v-model="form.operType" placeholder="请输入操作类型" />
        </el-form-item>
        <el-form-item label="关联id" prop="relateId">
          <el-input v-model="form.relateId" placeholder="请输入关联id" />
        </el-form-item>
        <el-form-item label="资金流向">
          <el-select v-model="form.flows" placeholder="请选择资金流向">
            <el-option
              v-for="dict in flowsOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="账户类型">
          <el-select v-model="form.accountType" placeholder="请选择账户类型">
            <el-option
              v-for="dict in accountTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="币种">
          <el-select v-model="form.coinType" placeholder="请选择币种">
            <el-option
              v-for="dict in coinTypeOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="操作人id" prop="operId">
          <el-input v-model="form.operId" placeholder="请输入操作人id" />
        </el-form-item>
        <el-form-item label="金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="操作后金额" prop="resultAmount">
          <el-input v-model="form.resultAmount" placeholder="请输入操作后金额" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listFlow, getFlow, delFlow, addFlow, updateFlow, exportFlow } from "@/api/system/flow";

export default {
  name: "Flow",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 总条数
      total: 0,
      // 流水记录表格数据
      flowList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 资金流向字典
      flowsOptions: [],
      // 账户类型字典
      accountTypeOptions: [],
      // 币种字典
      coinTypeOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        id: undefined,
        userId: undefined,
        operType: undefined,
        relateId: undefined,
        flows: undefined,
        accountType: undefined,
        coinType: undefined,
        phone: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
        operType: [
          { required: true, message: "操作类型不能为空", trigger: "blur" }
        ],
        relateId: [
          { required: true, message: "关联id不能为空", trigger: "blur" }
        ],
        flows: [
          { required: true, message: "资金流向不能为空", trigger: "blur" }
        ],
        accountType: [
          { required: true, message: "账户类型不能为空", trigger: "blur" }
        ],
        coinType: [
          { required: true, message: "币种不能为空", trigger: "blur" }
        ],
        operId: [
          { required: true, message: "操作人id不能为空", trigger: "blur" }
        ],
        amount: [
          { required: true, message: "金额不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "修改时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("buy_sale").then(response => {
      this.flowsOptions = response.data;
    });
    this.getDicts("account_type").then(response => {
      this.accountTypeOptions = response.data;
    });
    this.getDicts("coin_type").then(response => {
      this.coinTypeOptions = response.data;
    });
  },
  methods: {
    /** 查询流水记录列表 */
    getList() {
      this.loading = true;
      listFlow(this.queryParams).then(response => {
        this.flowList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 资金流向字典翻译
    flowsFormat(row, column) {
      return this.selectDictLabel(this.flowsOptions, row.flows);
    },
    // 账户类型字典翻译
    accountTypeFormat(row, column) {
      return this.selectDictLabel(this.accountTypeOptions, row.accountType);
    },
    // 币种字典翻译
    coinTypeFormat(row, column) {
      return this.selectDictLabel(this.coinTypeOptions, row.coinType);
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: undefined,
        userId: undefined,
        operType: undefined,
        relateId: undefined,
        flows: undefined,
        accountType: undefined,
        coinType: undefined,
        operId: undefined,
        amount: undefined,
        resultAmount: undefined,
        createTime: undefined,
        updateTime: undefined,
        phone: undefined
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!=1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加流水记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFlow(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改流水记录";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateFlow(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addFlow(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("新增成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$confirm('是否确认删除流水记录编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delFlow(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有流水记录数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportFlow(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
