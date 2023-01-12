
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

    if(evt.target.value.length > 11){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarUsername(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length > 15){
        theEvent.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}

function validarTelefone(evt) {
    var theEvent = evt || window.event;

    if(evt.target.value.length > 20){
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
    produtos.forEach((e) => {
        let options = e.children[0].options
        let selected = options.selectedIndex

        let preco = options[selected].getAttribute('preco')
        let qtd =  e.children[1].value

        total += (preco * qtd)

    })

    var atual = 600000.00;

//com R$
    let f = total.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});

//sem R$
//     var f2 = atual.toLocaleString('pt-br', {minimumFractionDigits: 2});

    document.getElementById("total").innerText = f
}

function maskFrete(el) {
    let value = el.value.replace('.', '').replace(',', '.')
    value = value.replace('.', '').replace(',', '').replace(/\D/g, '')

    const options = { minimumFractionDigits: 1, maximumFractionDigits: 2 }
    const result = new Intl.NumberFormat('en', options).format(
        parseFloat(value) / 100
    )

    el.value = result

}