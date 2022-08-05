import axios from 'axios'

const EMPS_API_URL = "http://localhost:8081/api/emps"

class EmpsService{
    getEmps(){
        return axios.get(EMPS_API_URL)
    }
}

export default new EmpsService()