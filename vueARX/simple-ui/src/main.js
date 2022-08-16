import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
// for ui design, see : https://semantic-ui-vue.github.io 
import {SuiVue} from 'semantic-ui-vue';

//createApp(App).use(store).use(router).mount('#app')
createApp(App).use(store).use(router).mount('#app').use(SuiVue);