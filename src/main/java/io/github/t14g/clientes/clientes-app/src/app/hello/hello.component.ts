import { Component } from '@angular/core';
import { ClientesComponent } from '../clientes/clientes.component';

@Component({
    selector: 'hello',
    templateUrl: './hello.component.html'
})
 
export class HelloComponent {

    nome : string;
    clientes : Cliente[];

    constructor(){
        this.nome  = 'Declaração de variável no typescript';
        let fulano = new Cliente('Fulano',20);
        let ciclano = new Cliente('Ciclano',40);

        this.clientes = [fulano, ciclano];
    }

}

class Cliente {

    constructor(
        public nome : string,
        public idade: number
    ){}
}