<template>
    <div>
        <a-card title="新增用户 CREATE USER" :bordered="false">
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
            <a-row>
                <a-col :span="24">
                    <a-form-model-item :wrapper-col="{ span: 14, offset: 4 }" class="text-align-center margin-top-10 margin-bottom-10">
                        <a-button type="primary" @click="createSubmit">
                            提交
                        </a-button>
                        <!-- <a-button style="margin-left: 10px;" @click="$refs.ruleForm.resetFields();">
                            重置
                        </a-button> -->
                    </a-form-model-item>
                </a-col>
            </a-row>
            </a-form-model>
        </a-card>
    </div>
</template>


<script>

import {saveUser, checkAccount}  from '@/api/HttpAPI';

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
            labelCol: {span: 4},
            wrapperCol: {span: 18},
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

    methods: {
        createSubmit() {
            this.$refs.ruleForm.validate(valid => {
                if (valid) {
                    saveUser(this.form).then(resp => {
                        if (resp.data == 1) {
                            this.$notification['success']({
                                message: '添加成功！',
                                description: '该疫情动态已添加至系统中，请在工具栏记录相关数据。',
                            });
                            this.createModalVisible = false;
                            this.$refs.ruleForm.resetFields();
                        } else {
                            this.$message.error('系统异常，请稍后再试。');
                        }
                    });
                } else {
                    return;
                }
            });
        },
    },
}
</script>