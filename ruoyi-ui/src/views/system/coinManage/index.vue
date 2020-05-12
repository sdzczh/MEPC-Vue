<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" label-width="68px">
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
          v-hasPermi="['system:coinManage:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:coinManage:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:coinManage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:coinManage:export']"
        >导出</el-button>
      </el-col>
    </el-row>

    <el-table v-loading="loading" :data="coinManageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="币种" align="center" prop="coinType" :formatter="coinTypeFormat" />
      <el-table-column label="币种名称" align="center" prop="name" />
      <el-table-column label="中文名称" align="center" prop="cnName" />
      <el-table-column label="充值地址" align="center" prop="address" />
      <el-table-column label="充值二维码地址" align="center" prop="rechargeUrl" />
      <el-table-column label="提现手续费" align="center" prop="withdrawFee" />
      <el-table-column label="充值手续费" align="center" prop="rechargeFee" />
      <el-table-column label="充值最大值" align="center" prop="rechargeAmountMax" />
      <el-table-column label="提现最大值" align="center" prop="withdrawAmountMax" />
      <el-table-column label="充值最小值" align="center" prop="rechargeAmountMin" />
      <el-table-column label="提现最小值" align="center" prop="withdrawAmountMin" />
      <el-table-column label="充值开关" align="center" prop="rechargeOnoff" :formatter="rechargeOnoffFormat" />
      <el-table-column label="提现开关" align="center" prop="withdrawOnoff" :formatter="withdrawOnoffFormat" />
      <el-table-column label="充值注意事项" align="center" prop="rechargeDoc" />
      <el-table-column label="提现注意事项" align="center" prop="withdrawDoc" />
      <el-table-column label="C2C开关" align="center" prop="c2cOnoff" :formatter="c2cOnoffFormat" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:coinManage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:coinManage:remove']"
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

    <!-- 添加或修改币种管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
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
        <el-form-item label="币种名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入币种名称" />
        </el-form-item>
        <el-form-item label="中文名称" prop="cnName">
          <el-input v-model="form.cnName" placeholder="请输入中文名称" />
        </el-form-item>
        <el-form-item label="充值地址" prop="address">
          <el-input v-model="form.address" placeholder="请输入充值地址" />
        </el-form-item>
        <el-form-item label="logo" prop="imgUrl">
          <el-input v-model="form.imgUrl" placeholder="请输入logo" />
        </el-form-item>
        <el-form-item label="充值二维码地址" prop="rechargeUrl">
          <el-input v-model="form.rechargeUrl" placeholder="请输入充值二维码地址" />
        </el-form-item>
        <el-form-item label="提现手续费" prop="withdrawFee">
          <el-input v-model="form.withdrawFee" placeholder="请输入提现手续费" />
        </el-form-item>
        <el-form-item label="充值手续费" prop="rechargeFee">
          <el-input v-model="form.rechargeFee" placeholder="请输入充值手续费" />
        </el-form-item>
        <el-form-item label="充值最大值" prop="rechargeAmountMax">
          <el-input v-model="form.rechargeAmountMax" placeholder="请输入充值最大值" />
        </el-form-item>
        <el-form-item label="提现最大值" prop="withdrawAmountMax">
          <el-input v-model="form.withdrawAmountMax" placeholder="请输入提现最大值" />
        </el-form-item>
        <el-form-item label="充值最小值" prop="rechargeAmountMin">
          <el-input v-model="form.rechargeAmountMin" placeholder="请输入充值最小值" />
        </el-form-item>
        <el-form-item label="提现最小值" prop="withdrawAmountMin">
          <el-input v-model="form.withdrawAmountMin" placeholder="请输入提现最小值" />
        </el-form-item>
        <el-form-item label="充值开关">
          <el-select v-model="form.rechargeOnoff" placeholder="请选择充值开关">
            <el-option
              v-for="dict in rechargeOnoffOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="提现开关">
          <el-select v-model="form.withdrawOnoff" placeholder="请选择提现开关">
            <el-option
              v-for="dict in withdrawOnoffOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="充值注意事项" prop="rechargeDoc">
          <el-input v-model="form.rechargeDoc" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="提现注意事项" prop="withdrawDoc">
          <el-input v-model="form.withdrawDoc" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="C2C开关">
          <el-select v-model="form.c2cOnoff" placeholder="请选择C2C开关">
            <el-option
              v-for="dict in c2cOnoffOptions"
              :key="dict.dictValue"
              :label="dict.dictLabel"
              :value="dict.dictValue"
            ></el-option>
          </el-select>
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
import { listCoinManage, getCoinManage, delCoinManage, addCoinManage, updateCoinManage, exportCoinManage } from "@/api/system/coinManage";

export default {
  name: "CoinManage",
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
      // 币种管理表格数据
      coinManageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 币种字典
      coinTypeOptions: [],
      // 充值开关字典
      rechargeOnoffOptions: [],
      // 提现开关字典
      withdrawOnoffOptions: [],
      // C2C开关字典
      c2cOnoffOptions: [],
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        coinType: undefined,
        name: undefined,
        cnName: undefined,
        address: undefined,
        imgUrl: undefined,
        rechargeUrl: undefined,
        withdrawFee: undefined,
        rechargeFee: undefined,
        rechargeAmountMax: undefined,
        withdrawAmountMax: undefined,
        rechargeAmountMin: undefined,
        withdrawAmountMin: undefined,
        rechargeOnoff: undefined,
        withdrawOnoff: undefined,
        rechargeDoc: undefined,
        withdrawDoc: undefined,
        c2cOnoff: undefined,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        coinType: [
          { required: true, message: "币种不能为空", trigger: "blur" }
        ],
        name: [
          { required: true, message: "币种名称不能为空", trigger: "blur" }
        ],
        cnName: [
          { required: true, message: "中文名称不能为空", trigger: "blur" }
        ],
        address: [
          { required: true, message: "充值地址不能为空", trigger: "blur" }
        ],
        imgUrl: [
          { required: true, message: "logo不能为空", trigger: "blur" }
        ],
        rechargeUrl: [
          { required: true, message: "充值二维码地址不能为空", trigger: "blur" }
        ],
        withdrawFee: [
          { required: true, message: "提现手续费不能为空", trigger: "blur" }
        ],
        rechargeFee: [
          { required: true, message: "充值手续费不能为空", trigger: "blur" }
        ],
        rechargeAmountMax: [
          { required: true, message: "充值最大值不能为空", trigger: "blur" }
        ],
        withdrawAmountMax: [
          { required: true, message: "提现最大值不能为空", trigger: "blur" }
        ],
        rechargeAmountMin: [
          { required: true, message: "充值最小值不能为空", trigger: "blur" }
        ],
        withdrawAmountMin: [
          { required: true, message: "提现最小值不能为空", trigger: "blur" }
        ],
        rechargeOnoff: [
          { required: true, message: "充值开关不能为空", trigger: "blur" }
        ],
        withdrawOnoff: [
          { required: true, message: "提现开关不能为空", trigger: "blur" }
        ],
        rechargeDoc: [
          { required: true, message: "充值注意事项不能为空", trigger: "blur" }
        ],
        withdrawDoc: [
          { required: true, message: "提现注意事项不能为空", trigger: "blur" }
        ],
        c2cOnoff: [
          { required: true, message: "C2C开关不能为空", trigger: "blur" }
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
    this.getDicts("coin_type").then(response => {
      this.coinTypeOptions = response.data;
    });
    this.getDicts("on_off").then(response => {
      this.rechargeOnoffOptions = response.data;
    });
    this.getDicts("on_off").then(response => {
      this.withdrawOnoffOptions = response.data;
    });
    this.getDicts("on_off").then(response => {
      this.c2cOnoffOptions = response.data;
    });
  },
  methods: {
    /** 查询币种管理列表 */
    getList() {
      this.loading = true;
      listCoinManage(this.queryParams).then(response => {
        this.coinManageList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 币种字典翻译
    coinTypeFormat(row, column) {
      return this.selectDictLabel(this.coinTypeOptions, row.coinType);
    },
    // 充值开关字典翻译
    rechargeOnoffFormat(row, column) {
      return this.selectDictLabel(this.rechargeOnoffOptions, row.rechargeOnoff);
    },
    // 提现开关字典翻译
    withdrawOnoffFormat(row, column) {
      return this.selectDictLabel(this.withdrawOnoffOptions, row.withdrawOnoff);
    },
    // C2C开关字典翻译
    c2cOnoffFormat(row, column) {
      return this.selectDictLabel(this.c2cOnoffOptions, row.c2cOnoff);
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
        coinType: undefined,
        name: undefined,
        cnName: undefined,
        address: undefined,
        imgUrl: undefined,
        rechargeUrl: undefined,
        withdrawFee: undefined,
        rechargeFee: undefined,
        rechargeAmountMax: undefined,
        withdrawAmountMax: undefined,
        rechargeAmountMin: undefined,
        withdrawAmountMin: undefined,
        rechargeOnoff: undefined,
        withdrawOnoff: undefined,
        rechargeDoc: undefined,
        withdrawDoc: undefined,
        c2cOnoff: undefined,
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
      this.title = "添加币种管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCoinManage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改币种管理";
      });
    },
    /** 提交按钮 */
    submitForm: function() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != undefined) {
            updateCoinManage(this.form).then(response => {
              if (response.code === 200) {
                this.msgSuccess("修改成功");
                this.open = false;
                this.getList();
              } else {
                this.msgError(response.msg);
              }
            });
          } else {
            addCoinManage(this.form).then(response => {
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
      this.$confirm('是否确认删除币种管理编号为"' + ids + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delCoinManage(ids);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(function() {});
    },
    /** 导出按钮操作 */
    handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有币种管理数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return exportCoinManage(queryParams);
        }).then(response => {
          this.download(response.msg);
        }).catch(function() {});
    }
  }
};
</script>
