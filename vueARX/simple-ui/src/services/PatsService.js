import axios from 'axios'

const Pats_API_URL = "http://localhost:8081/api/pats"

class PatsService{
    getPats(){
        return axios.get(Pats_API_URL)
    }
}

export default new PatsService()