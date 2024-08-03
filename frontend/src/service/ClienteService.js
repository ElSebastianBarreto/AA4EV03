//conexion con backend
import axios from 'axios';

export class ClienteService{
    baseUrl="http://localhost:8080/clientes";
    getAll(){
        return axios.get(this.baseUrl).then(res => res.data);
    }
//guarda clientes
    save(cliente){
        return axios.get(this.baseUrl, cliente).then(res => res.data);
    }
}