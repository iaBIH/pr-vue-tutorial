import axios from 'axios'

const ARX_API_URL = "http://localhost:8081/api/arx"

class ArxService{
    getArxData(){
        return axios.get(ARX_API_URL)
    }
}

export default new ArxService()