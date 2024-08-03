import logo from './logo.svg';
import './App.css';
import { Component } from 'react';
import { ClienteService } from './service/ClienteService';
import {DataTable} from 'primereact/datatable';
import {Column} from 'primereact/column';
import { Menubar } from 'primereact/menubar';
import { Dialog } from 'primereact/dialog';
import { InputText } from 'primereact/inputtext';
export default class App extends Component{
  constructor(){
super();
this.state = {};
this.items = [
{
  label: 'Nuevo',
  icon : 'pi pi-fw pi-plus',
  command : () => {this.showSaveDialog()}
},
{
  label: 'Editar',
  icon : 'pi pi-fw pi-pencil',
  command : () => {alert('edit')}
},
{
  label: 'Eliminar',
  icon : 'pi pi-fw pi-trash',
  command : () => {alert('deleted')}
},
];

this.clienteService = new ClienteService();

  }
componentDidMount(){
  this.clienteService.getAll().then(data =>this.setState({cliente: data}))
  this.setState({visible: false,
    cliente:{
      cedula: null,
      nombre: null,
      apellido: null,
      telefono: null,
      correo: null,
      clave: null,
    }
  });
}
//funcion de guardar
save(){
  this.clienteService.save(this.state.cliente).then(data =>{console.log(data);})
}

render(){
  return(

// tabla con informacion de la base de datos
<div style={{width:'80%', margin:'0 auto', marginTop:'20px'}}>
<Menubar model={this.state.cliente}/>
<br/>
<DataTable value={this.state.cliente}>

<Column field="cedula" header="cedula"></Column>
<Column field="nombre" header="nombres"></Column>
<Column field="apellido" header="apellidos"></Column>
<Column field="edad" header="edad"></Column>
<Column field="telefono" header="telefono"></Column>
<Column field="correo" header="correo"></Column>
<Column field="clave" header="clave"></Column>
</DataTable>
<dialog header="Crear cliente" visible={this.state.visible} style={{width:'60%'}} modal={true} onHide={() => this.setState({visible: false})}>
  <InputText value={this.state.value} id="cedula"onChange={(e) => this.setState(prevState => {
    let cliente = Object.assign({}, prevState.cliente)
    cliente.cedula = e.target.value
    return{cliente};
    })}></InputText>
    <label htmlFor="cedula ">cedula</label>

    <InputText value={this.state.value} id="nombre"onChange={(e) => this.setState(prevState => {
    let cliente = Object.assign({}, prevState.cliente)
    cliente.nombre = e.target.value

    return{cliente};
    })}></InputText>
    <label htmlFor="nombre ">nombre</label>

    <InputText value={this.state.value} id="apellido"onChange={(e) => this.setState(prevState => {
    let cliente = Object.assign({}, prevState.cliente)
    cliente.apellido = e.target.value

    return{cliente};
    })}></InputText>
    <label htmlFor="apellido ">apellido</label>

    <InputText value={this.state.value} id="telefono"onChange={(e) => this.setState(prevState => {
    let cliente = Object.assign({}, prevState.cliente)
    cliente.telefono = e.target.value

    return{cliente};
    })}></InputText>
    <label htmlFor="telefono ">telefono</label>

    <InputText value={this.state.value} id="correo"onChange={(e) => this.setState(prevState => {
    let cliente = Object.assign({}, prevState.cliente)
    cliente.correo = e.target.value

    return{cliente};
    })}></InputText>
    <label htmlFor="correo ">correo</label>

    <InputText value={this.state.value} id="clave"onChange={(e) => this.setState(prevState => {
    let cliente = Object.assign({}, prevState.cliente)
    cliente.clave = e.target.value

    return{cliente};
    })}></InputText>
    <label htmlFor="clave ">clave</label>
</dialog>
</div>
  );
}

}
