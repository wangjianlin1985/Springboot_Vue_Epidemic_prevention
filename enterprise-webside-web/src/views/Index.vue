<template>
    <a-layout id="components-layout-custom-trigger">
        <a-layout-sider v-model="collapsed" :trigger="null" collapsible :width="siderWidth" class="layout-sider">
            <div class="side-logo" v-if="collapsed == false">ADMIN <span style="color:#1E90FF;font-size: 1.105em;">SYSTEM</span></div>
            <div class="side-logo" v-if="collapsed == true">A<span style="color:#1E90FF;font-size: 1.105em;">S</span></div>
            <a-menu
                mode="inline"
                theme="dark"
                :default-selected-keys="['0']"
                :default-open-keys="['menu_1']"
                :style="{borderRight: 0}"
            >

            <a-menu-item key="0">
                <router-link to="/home"><a-icon type="desktop" />监测中心</router-link>
            </a-menu-item>

            <a-sub-menu key="menu_1">
                <span slot="title"><a-icon type="medicine-box" /><span>疫情人员管理</span></span>
                <a-menu-item key="1">
                    <router-link to="/patientL1">确诊感染者信息管理</router-link>
                </a-menu-item>
                <a-menu-item key="2">
                    <router-link to="/patientL2">入境人员信息管理</router-link>
                </a-menu-item>
                <a-menu-item key="3">
                    <router-link to="/patientL3">中高风险接触者信息管理</router-link>
                </a-menu-item>
                <a-menu-item key="4">
                    <router-link to="/patientL4">低风险接触者信息管理</router-link>
                </a-menu-item>
            </a-sub-menu>

            <a-sub-menu key="menu_2">
                <span slot="title"><a-icon type="project"/><span>疫情工作管理</span></span>
                <a-menu-item key="5">
                    <router-link to="/news">疫情动态</router-link>
                </a-menu-item>
                <a-menu-item key="6">
                    <router-link to="/leader">领导信息</router-link>
                </a-menu-item>
            </a-sub-menu>

            <a-sub-menu key="menu_3">
                <span slot="title"><a-icon type="user" /><span>用户管理</span></span>
                <a-menu-item key="100">
                    <router-link to="/createUser">新增用户</router-link>
                </a-menu-item>
                <a-menu-item key="101">
                    <router-link to="/searchUser">用户查询</router-link>
                </a-menu-item>
            </a-sub-menu>
        </a-menu>
    </a-layout-sider>
    <a-layout>
      <a-layout-header class="layout-header">
        <a-row>
          <a-col :span="12">
              <a-icon
            class="trigger"
            :type="collapsed ? 'menu-unfold' : 'menu-fold'"
            @click="() => (collapsed = !collapsed)"
          />
          </a-col>
          <a-col :span="8">
            <a-icon type="poweroff" class="logoutBtn" @click="logout"/>
          </a-col>
          <a-col :span="4">
          </a-col>
        </a-row>
      </a-layout-header>
      <a-layout-content class="layout-content">
        <router-view></router-view>
        <div style="height:100px; width:100%"></div>
      </a-layout-content>
    </a-layout>
  </a-layout>
</template>
<script>


export default {
  data() {
    return {
      collapsed: false,
      siderWidth: 250,
    };
  },

  methods: {
    logout() {
      let that = this;
      this.$confirm({
          title: '你确定要注销吗？',
          onOk() {
              that.$router.push({name: 'Loadding'});
          },
          onCancel() {},
      });
    }
  }
};
</script>
<style>
#components-layout-custom-trigger {
    height: 100%
}

#components-layout-custom-trigger .trigger {
  font-size: 18px;
  line-height: 64px;
  padding: 0 24px;
  cursor: pointer;
  transition: color 0.3s;
}

#components-layout-custom-trigger .trigger:hover {
  color: #1890ff;
}

#components-layout-custom-trigger .logo {
  height: 32px;
  background: rgba(255, 255, 255, 0.2);
  margin: 16px;
}
</style>
