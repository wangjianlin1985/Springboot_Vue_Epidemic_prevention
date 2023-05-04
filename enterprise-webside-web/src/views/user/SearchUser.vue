<template>
    <div>
        <a-row>
            <a-col :span="24" class="table-tools">
                <a-button type="primary" icon="delete" @click="deletePatient">删除</a-button>
                <a-button type="defalut" icon="form" @click="editPatient">修改</a-button>
            </a-col>
        </a-row>
        <a-card title="系统用户管理" :bordered="false">
            <a-table
                  :columns="columns"
                  :row-key="record => record.id"
                  :data-source="data"
                  :pagination="pagination"
                  :loading="loading"
                  @change="handleTableChange"
                  :row-selection="{type: 'radio', selectedRowKeys: selectedRowKeys, onChange: onSelectChange}"
              >
            </a-table>
        </a-card>

        <a-modal
            title="修改用户"
            :visible="createModalVisible"
            @ok="editSubmit"
            @cancel="createModalVisible=false"
            width="80%"
        >
          <a-form-model :model="form" :label-col="labelCol" :wrapper-col="wrapperCol" :rules="rules" ref="ruleForm">
            <a-row>
                <a-col :span="24">
                    <a-row>
                        <a-col :span="8">
                            <a-form-model-item label="用户昵称" prop="nickName">
                                <a-input v-model="form.nickName" placeholder="请输入用户昵称"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="8">
                            <a-form-model-item label="登录账户" prop="account">
                                <a-input v-model="form.account" placeholder="请输入登录账户"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="8">
                            <a-form-model-item label="登录密码" prop="password">
                                <a-input-password v-model="form.password" placeholder="请输入登录密码"/>
                            </a-form-model-item>
                        </a-col>
                    </a-row>
                    
                    <a-row>
                        <a-col :span="8">
                            <a-form-model-item label="确认密码" prop="repassword">
                                <a-input-password v-model="form.repassword" placeholder="请输入确认密码"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="8">
                            <a-form-model-item label="用户性别" prop="gender">
                                <a-select v-model="form.gender" placeholder="请选择用户性别">
                                    <a-select-option value="male">
                                        男
                                    </a-select-option>
                                    <a-select-option value="female">
                                        女
                                    </a-select-option>
                                </a-select>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="8">
                            <a-form-model-item label="联系电话" prop="phoneNo">
                                <a-input v-model="form.phoneNo" placeholder="请输入联系电话"/>
                            </a-form-model-item>
                        </a-col>
                    </a-row>                   
                </a-col>
            </a-row>
          </a-form-model>
        </a-modal>
    </div>
</template>

<script>

import {updateUserById, deleteUserById, selectUser, checkAccount}  from '@/api/HttpAPI';

export default {
  data() {
    let checkPassword = (rule, value, callback) => {
        if (value.length > 6 && value !== this.form.password) {
            callback(new Error("确认密码和密码必须一致。"));
        } else {
            callback();
        }
    };
    let checkAccountValue = (rule, value, callback) => {
        checkAccount({id: this.patientInfo.id, account: value}).then(resp => {
            if (resp.data == 0) {
                callback();
            } else {
                callback(new Error("该账户已被使用。"));
            }
        })
    };
    return {
      data: [],
      pagination: {
        current: 1
      },
      loading: false,
      columns,
      createModalVisible: false,
      labelCol: {span: 4},
      wrapperCol: {span: 18},
      selectedRowKeys: [],
      patientInfo : {},
      form: {
          nickName: '',
          account: '',
          password: '',
          repassword: '',
          gender: undefined,
          phoneNo: ''
      },
      rules: {
          nickName: [
              {required: true, message: '请输入用户昵称', trigger: 'blur'},
          ],
          account: [
              {required: true, message: '请输入登录账户', trigger: 'blur'},
              {validator: checkAccountValue, trigger: 'blur'}
          ],
          password: [
              {required: true, message: '请输入登录密码', trigger: 'blur'},
              {min: 6, message: '请输入六位数及以上的密码', trigger: 'blur'},
          ],
          repassword: [
              {required: true, message: '请输入确认密码', trigger: 'blur'},
              {min: 6, message: '请输入六位数及以上的确认密码', trigger: 'blur'},
              {validator: checkPassword, trigger: 'blur'}
          ],
          gender: [
              {required: true, message: '请选择用户性别', trigger: 'blur'},
          ],
          phoneNo: [
              {required: true, message: '请输入联系电话', trigger: 'blur'},
          ],
      }
    };
  },
  mounted() {
    this.fetch();
  },

  methods: {
    checkSelect() {
        if (this.selectedRowKeys.length == 0) {
            this.$message.warning('请选择一条数据再进行操作。');
            return false;
        } else {
            return true;
        }
    },

    editPatient() {
        if (!this.checkSelect()) {
            return;
        }

        this.createModalVisible = true;
        this.form = {...this.patientInfo};
        this.form.repassword = this.form.password;
    },

    editSubmit() {
        this.$refs.ruleForm.validate(valid => {
            if (valid) {
                updateUserById(this.form).then(resp => {
                    if (resp.data == 1) {
                        this.$notification['success']({
                            message: '修改成功！',
                            description: '该用户的信息已被修改。',
                        });
                        this.createModalVisible = false;
                        this.fetch();
                        this.selectedRowKeys = [];
                    } else {
                        this.$message.error('系统异常，请稍后再试。');
                    }

                    this.$refs.ruleForm.resetFields();
                });
            } else {
                return;
            }
        });
    },

    deletePatient() {
        const that = this;
        if (!this.checkSelect()) {
            return;
        }

        this.$confirm({
            title: '你确定要删除这个用户吗？',
            content: '删除后系统将不会保留这个用户的所有信息。',
            onOk() {
                const params = {
                    id: that.patientInfo.id
                };
                deleteUserById(params).then(resp => {
                    if (resp.data == 1) {
                        that.$notification['success']({
                            message: '删除成功！',
                            description: '该疫情用户已被删除。',
                        });
                        that.fetch();
                    } else {
                        that.$message.error('系统异常，请稍后再试。');
                    }
                });
            },
            onCancel() {},
        });
    },

    onSelectChange(value) {
        this.selectedRowKeys = value;
        
        let index = 0;
        for (index in this.data) {
            if (this.data[index].id === this.selectedRowKeys[0]) {
                this.patientInfo = this.data[index];
                this.patientName = this.data[index].name;
                break;
            }
        }
    },

    handleTableChange(pagination) {
        const pager = {...this.pagination};
        pager.current = pagination.current;
        this.pagination = pager;
        this.fetch();
    },

    fetch() {
      this.loading = true;
      const params = {
          currPage: this.pagination.current
      };
      selectUser(params).then(resp => {
          const data = resp.data;
          const pagination = { ...this.pagination };
          pagination.total = data.count;
          this.loading = false;
          this.data = data.data;
          this.pagination = pagination;
      });
    },
  },
};

const columns = [{
    title: '用户昵称',
    dataIndex: 'nickName',
}, {
    title: '性别',
    dataIndex: 'gender',
    customRender: (value) => {
        if ('male' === value) {
            return '男';
        } else {
            return '女';
        }
    }
}, {
    title: '账户',
    dataIndex: 'account',
}, {
    title: '手机号',
    dataIndex: 'phoneNo'
}];

</script>