import { Component, OnInit } from '@angular/core';
import { Factura } from './../factura';
import { Cliente } from './../cliente';
import { Detalle } from './../detalle';
import { Producto } from './../producto';

@Component({
  selector: 'app-factura',
  templateUrl: './factura.component.html',
  styleUrls: ['./factura.component.css']
})
export class FacturaComponent implements OnInit {

  Factura: Factura = new Factura();
  Cliente: Cliente = new Cliente();
  Detalle: Detalle = new Detalle();
  Producto: Producto = new Producto();

  constructor() { }

  ngOnInit() {
    console.log(this.Factura);
    console.log(this.Cliente);
    console.log(this.Detalle);
    console.log(this.Producto);

  }

  onSubmit(){
    console.log(this.Factura);
    console.log(this.Cliente);
    console.log(this.Detalle);
    console.log(this.Producto);
  }

}
