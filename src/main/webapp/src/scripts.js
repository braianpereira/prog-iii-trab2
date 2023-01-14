/*
* Validações cliente
* */
function validarCpf(evt) {
    var theEvent = evt || window.event;

    // Handle paste
    if (theEvent.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        var key = theEvent.keyCode || theEvent.which;
        key = String.fromCharCode(key);
    }
    var regex = /[0-9]|\./;
    if( !regex.test(key) ) {
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }

    if(evt.target.value.length >= 11){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarCpf(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length >= 11){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarNomeCliente(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length >= 100){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarOrgaoEmissor(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 20){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarEmail(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length >= 100){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarTelefoneCliente(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 20){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarLogradouro(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 100){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}
function validarNumero(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 20){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarBairro(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 45){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarCidade(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 45){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarEstado(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 2){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarRG(evt) {
    var theEvent = evt || window.event;


    if(evt.target.value.length >= 15){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

/*
* Validações usuario
* */

function validarUsername(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length >= 15){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarTelefoneUsuario(evt) {
    var theEvent = evt || window.event;

    if (evt.target.value.length >= 20) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault) theEvent.preventDefault();
    }
}
/*
* Validações produto
* */
function validarNomeProduto(evt) {
    var theEvent = evt || window.event;

    if (evt.target.value.length >= 100) {
        theEvent.returnValue = false;
        if (theEvent.preventDefault) theEvent.preventDefault();
    }
}
function validarUnidade(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length >= 3){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function addProduto() {
    let produtos = document.querySelector(".produtos")
    let produto = produtos.querySelector("fieldset")
    let clone = produto.cloneNode(true)
    produtos.appendChild(clone)

}

function removeProduto(el) {
    if (document.getElementsByClassName("produtos")[0].children.length > 1){
        let produto = el.parentElement
        produto.remove()
    } else {
        alert("Pelo menos um produto é obrigatório");
    }
}

function updateTotal(){

    let produtos = Array.from(document.getElementsByClassName("produtos")[0].children)
    let total = 0;

    let Valor_Frete = document.getElementById('Valor_Frete').value

    if (Valor_Frete == ''){
        document.getElementById('Valor_Frete').value = '0'
        Valor_Frete = '0'
    }

    produtos.forEach((e) => {
        let options = e.children[0].options
        let selected = options.selectedIndex

        let preco = options[selected].getAttribute('preco')
        let qtd =  e.children[1].value


        total += (preco * qtd)


    })



    total += parseFloat(Valor_Frete)

    document.getElementById("total").innerText = total.toLocaleString('pt-br', {style: 'currency', currency: 'BRL'})
}


