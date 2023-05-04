import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [{
    path: '/',
    name: 'Loadding',
    component: () => import('../views/Loadding.vue')
}, {
  path: '/logon',
  name: 'Logon',
  component: () => import('../views/Logon.vue')
}, {
  path: '/index',
  name: 'Index',
  component: () => import('../views/Index.vue'),
  children: [{
    path: '/createUser',
    name: 'CreateUser',
    component: () => import('../views/user/CreateUser')
  }, {
    path: '/searchUser',
    name: 'SearchUser',
    component: () => import('../views/user/SearchUser')
  }, {
    path: '/patientL1',
    name: 'PatientL1',
    component: () => import('../views/patient/Patient_L1.vue')
  }, {
    path: '/patientL2',
    name: 'PatientL2',
    component: () => import('../views/patient/Patient_L2.vue')
  }, {
    path: '/patientL3',
    name: 'PatientL3',
    component: () => import('../views/patient/Patient_L3.vue')
  }, {
    path: '/patientL4',
    name: 'PatientL4',
    component: () => import('../views/patient/Patient_L4.vue')
  }, {
    path: '/news',
    name: 'News',
    component: () => import('../views/manager/News.vue')
  }, {
    path: '/leader',
    name: 'Leader',
    component: () => import('../views/manager/Leader.vue')
  }, {
    path: '/home',
    name: 'Home',
    component: () => import('../views/Home.vue')
  }]
}]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
