import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/datareadwrite',
    name: 'datareadwrite',
    component: () => import(/* webpackChunkName: "datareadwrite" */ '../views/DataReadWriteView.vue')
  },  
  {
    path: '/configtransform',
    name: 'config_transform',
    component: () => import(/* webpackChunkName: "config_transform" */ '../views/ConfigTransformView.vue')
  },
  {
    path: '/exploreresults',
    name: 'explore_results',
    component: () => import(/* webpackChunkName: "explore_results" */ '../views/ExploreResultsView.vue')
  },
  {
    path: '/analyzeutility',
    name: 'analyze_utility',
    component: () => import(/* webpackChunkName: "analyze_utility" */ '../views/AnalyzeUtilityView.vue')
  }, 
  {
    path: '/analyzerisk',
    name: 'analyze_risk',
    component: () => import(/* webpackChunkName: "analyze_risk" */ '../views/AnalyzeRiskView.vue')
  }, 
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
