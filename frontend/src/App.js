import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import { ClienteService } from './service/ClienteService';
import {DataTable} from 'primereact/datatable';
import {Column} from 'primereact/column';
export default class App extends Component{
  constructor(){
super();
this.state = {};

this.clienteService = new ClienteService();

  }
componentDidMount(){
  this.clienteService.getAll().then(data =>this.setState({cliente: data}))
}
render(){
  return(

<DataTable value={this.state.cliente}>

<Column field="cedula" header="cedula"></Column>
<Column field="nombre" header="nombres"></Column>
<Column field="apellido" header="apellidos"></Column>
<Column field="edad" header="edad"></Column>
<Column field="telefono" header="telefono"></Column>
<Column field="correo" header="correo"></Column>
<Column field="clave" header="clave"></Column>
</DataTable>


  );
}

}
