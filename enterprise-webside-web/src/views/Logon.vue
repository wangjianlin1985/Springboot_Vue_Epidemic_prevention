<template>
    <div>
        <a-row class="logon">
            <a-col :span="12" class="logon-left">
                <div class="logo">疫情检测 <span>Monitor</span></div>
            </a-col>
            <a-col :span="12" class="logon-right">
                <a-form-model class="logon-form" 
                    :model="form" 
                    :rules="rules"
                    ref="logonForm">
                    <a-page-header
                        title="LOGON"
                        sub-title="使用账户名和密码登录"
                        class="logon-header"
                    />
                    <a-form-model-item prop="account" class="logon-form-item">
                        <a-input v-model="form.account" placeholder="请输入登录账号"/>
                    </a-form-model-item>

                    <a-form-model-item prop="password" class="logon-form-item">
                        <a-input-password v-model="form.password" placeholder="请输入登录密码"/>
                    </a-form-model-item>

                    <a-form-model-item> 
                        <a-button type="primary" shape="circle" block :loading="loading" @click="onSubmit">
                            登录
                        </a-button>
                    </a-form-model-item>

                    <a-form-model-item> 
                        <a-button type="default" shape="circle" block @click="createModalVisible=true">
                            注册
                        </a-button>
                    </a-form-model-item>
                </a-form-model>
            </a-col>
        </a-row>




        <a-modal
            title="注册用户"
            :visible="createModalVisible"
            @ok="registerSubmit"
            @cancel="createModalVisible=false"
            width="40%"
        >
          <a-form-model :model="registerform" :label-col="labelCol" :wrapper-col="wrapperCol" :rules="registerRules" ref="ruleRegisterformForm">
            <a-row>
                <a-col :span="24">
                    <a-row>
                        <a-col :span="24">
                            <a-form-model-item label="用户昵称" prop="nickName">
                                <a-input v-model="registerform.nickName" placeholder="请输入用户昵称"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="24">
                            <a-form-model-item label="登录账户" prop="account">
                                <a-input v-model="registerform.account" placeholder="请输入登录账户"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="24">
                            <a-form-model-item label="登录密码" prop="password">
                                <a-input-password v-model="registerform.password" placeholder="请输入登录密码"/>
                            </a-form-model-item>
                        </a-col>
                    </a-row>
                    
                    <a-row>
                        <a-col :span="24">
                            <a-form-model-item label="确认密码" prop="repassword">
                                <a-input-password v-model="registerform.repassword" placeholder="请输入确认密码"/>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="24">
                            <a-form-model-item label="用户性别" prop="gender">
                                <a-select v-model="registerform.gender" placeholder="请选择用户性别">
                                    <a-select-option value="male">
                                        男
                                    </a-select-option>
                                    <a-select-option value="female">
                                        女
                                    </a-select-option>
                                </a-select>
                            </a-form-model-item>
                        </a-col>
                        <a-col :span="24">
                            <a-form-model-item label="联系电话" prop="phoneNo">
                                <a-input v-model="registerform.phoneNo" placeholder="请输入联系电话"/>
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
import {saveUser, logon, checkAccount}  from '@/api/HttpAPI';
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
            checkAccount({account: value}).then(resp => {
                if (resp.data == 0) {
                    callback();
                } else {
                    callback(new Error("该账户已被使用。"));
                }
            })
        };
        return {
            createModalVisible: false,
            labelCol: {span: 4},
            wrapperCol: {span: 18},
            loading: false,
            form: {
                account: '',
                password: ''
            },
            registerform: {
                nickName: '',
                account: '',
                password: '',
                repassword: '',
                gender: undefined,
                phoneNo: ''
            },
            rules: {
                account: [
                    {required: true, message: '请输入登录账户', trigger: 'blur'},
                ],
                password: [
                    {required: true, message: '请输入登录密码', trigger: 'blur'},
                ],
            },
            registerRules: {
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
                ]
            }
        }
    },

    methods: {
        onSubmit() {
            this.$refs.logonForm.validate(valid => {
                if (valid) {
                    this.loading = true;
                    logon(this.form).then(resp => {
                        if (resp.data == "") {
                            this.$message.error('登录失败，用户名或密码不对。');
                        } else {
                            window.sessionStorage.setItem("USERID", resp.data.id);
                            this.$message.success('登陆成功！');
                            this.$router.push({name: 'Home'});
                        }
                    });
                    this.loading = false;
                } else {
                    return false;
                }
            });
        },

        registerSubmit() {
            this.$refs.ruleRegisterformForm.validate(valid => {
                if (valid) {
                    saveUser(this.registerform).then(resp => {
                        if (resp.data == 1) {
                            this.$message.success('注册成功，你现在可以登录系统了。');
                            this.createModalVisible = false;
                            this.$refs.ruleRegisterformForm.resetFields();
                        } else {
                            this.$message.error('系统异常，请稍后再试。');
                        }
                    });
                } else {
                    return;
                }
            });
        },
    }
}
</script>

<style scoped>

</style>