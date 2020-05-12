<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
      <el-form-item label="用户id" prop="userId">
        <el-input
          v-model="queryParams.userId"
          placeholder="请输入用户id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="类型" prop="type">
        <el-select v-model="queryParams.type" placeholder="请选择类型" clearable size="small">
          <el-option
            v-for="dict in typeOptions"
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
      <el-form-item label="订单号" prop="orderNum">
        <el-input
          v-model="queryParams.orderNum"
          placeholder="请输入订单号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="状态 " prop="state">
        <el-input
          v-model="queryParams.state"
          placeholder="请输入状态 "
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
          v-hasPermi="['system:orderTaker:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:orderTaker:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:orderTaker:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:orderTaker:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="orderTakerList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="用户id" align="center" prop="userId" />
      <el-table-column label="类型" align="center" prop="type" :formatter="typeFormat" />
      <el-table-column label="币种" align="center" prop="coinType" :formatter="coinTypeFormat" />
      <el-table-column label="makerId" align="center" prop="makerUserId" />
      <el-table-column label="价格" align="center" prop="price" />
      <el-table-column label="金额" align="center" prop="amount" />
      <el-table-column label="总额" align="center" prop="total" />
      <el-table-column label="订单号" align="center" prop="orderNum" />
      <el-table-column label="状态 " align="center" prop="state" :formatter="stateFormat" />
      <el-table-column label="过期时间" align="center" prop="inactiveTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.inactiveTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="创建时间" align="center" prop="createTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createTime) }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:orderTaker:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:orderTaker:remove']"
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

    <!-- 添加或修改法币订单管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="用户id" prop="userId">
          <el-input v-model="form.userId" placeholder="请输入用户id" />
        </el-form-item>
        <el-form-item label="类型">
          <el-select v-model="form.type" placeholder="请选择类型">
            <el-option
              v-for="dict in typeOptions"
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
        <el-form-item label="makerId" prop="makerUserId">
          <el-input v-model="form.makerUserId" placeholder="请输入makerId" />
        </el-form-item>
        <el-form-item label="订单id" prop="makerId">
          <el-input v-model="form.makerId" placeholder="请输入订单id" />
        </el-form-item>
        <el-form-item label="价格" prop="price">
          <el-input v-model="form.price" placeholder="请输入价格" />
        </el-form-item>
        <el-form-item label="金额" prop="amount">
          <el-input v-model="form.amount" placeholder="请输入金额" />
        </el-form-item>
        <el-form-item label="总额" prop="total">
          <el-input v-model="form.total" placeholder="请输入总额" />
        </el-form-item>
        <el-form-item label="支付id" prop="payId">
          <el-input v-model="form.payId" placeholder="请输入支付id" />
        </el-form-item>
        <el-form-item label="订单号" prop="orderNum">
          <el-input v-model="form.orderNum" placeholder="请输入订单号" />
        </el-form-item>
        <el-form-item label="状态 " prop="state">
          <el-input v-model="form.state" placeholder="请输入状态 " />
        </el-form-item>
        <el-form-item label="过期时间" prop="inactiveTime">
          <el-date-picker clearable size="small" style="width: 200px"
            v-model="form.inactiveTime"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择过期时间">
          </el-date-picker>
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
import { listOrderTaker, getOrderTaker, delOrderTaker, addOrderTaker, updateOrderTaker, exportOrderTaker } from "@/api/system/orderTaker";

export default {
  name: "OrderTaker",
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
      // 法币订单管理表格数据
      orderTakerList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 类型 0买 1卖字典
      typeOptions: [],
      // 币种字典
      coinTypeOptions: [],
      // 状态 字典
      stateOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        userId: undefined,
        type: undefined,
        coinType: undefined,
        payId: undefined,
        orderNum: undefined,
        state: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        userId: [
          { required: true, message: "用户id不能为空", trigger: "blur" }
        ],
        type: [
          { required: true, message: "类型 0买 1卖不能为空", trigger: "blur" }
        ],
        coinType: [
          { required: true, message: "币种不能为空", trigger: "blur" }
        ],
        makerUserId: [
          { required: true, message: "makerId不能为空", trigger: "blur" }
        ],
        makerId: [
          { required: true, message: "订单id不能为空", trigger: "blur" }
        ],
        price: [
          { required: true, message: "价格不能为空", trigger: "blur" }
        ],
        amount: [
          { required: true, message: "金额不能为空", trigger: "blur" }
        ],
        total: [
          { required: true, message: "总额不能为空", trigger: "blur" }
        ],
        orderNum: [
          { required: true, message: "订单号不能为空", trigger: "blur" }
        ],
        state: [
          { required: true, message: "状态 不能为空", trigger: "blur" }
        ],
        inactiveTime: [
          { required: true, message: "过期时间不能为空", trigger: "blur" }
        ],
        remark: [
          { required: true, message: "备注不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ],
        updateTime: [
          { required: true, message: "更新时间不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
    this.getDicts("buy_sale").then(response => {
      this.typeOptions = response.data;
    });
    this.getDicts("coin_type").then(response => {
      this.coinTypeOptions = response.data;
    });
    this.getDicts("order_state").then(response => {
      this.stateOptions = response.data;
    });
  },
  methods: {
    /** 查询法币订单管理列表 */
    getList() {
      this.loading = true;
      listOrderTaker(this.queryParams).then(response => {
        this.orderTakerList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 类型 0买 1卖字典翻译
    typeFormat(row, column) {
      return this.selectDictLabel(this.typeOptions, row.type);
    },
    // 币种字典翻译
    coinTypeFormat(row, column) {
      return this.selectDictLabel(this.coinTypeOptions, row.coinType);
    },
    // 状态 字典翻译
    stateFormat(row, column) {
      return this.selectDictLabel(this.stateOptions, row.state);
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
        type: undefined,
        coinType: undefined,
        makerUserId: undefined,
        makerId: undefined,
        price: undefined,
        amount: undefined,
        total: undefined,
        payId: undefined,
        orderNum: undefined,
        state: undefined,
        inactiveTime: undefined,
        remark: undefined,
        createTime: undefined,
        updateTime: undefined
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
      this.title = "添加法币订单管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getOrderTaker(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改法币订单管理";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateOrderTaker(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addOrderTaker(this.form).then(response => {
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
      this.$confirm('是否确认删除法币订单管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delOrderTaker(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有法币订单管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportOrderTaker(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
