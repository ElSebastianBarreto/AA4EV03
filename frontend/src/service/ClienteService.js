//conexion con backend
import axios from 'axios';

export class ClienteService{
    baseUrl="http://localhost:8080/clientes";
    getAll(){
        return axios.get(this.baseUrl+"all").then(res => res.data);
    }
}