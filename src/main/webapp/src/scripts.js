/*
* Validações cliente
* */
function validarCpf(evt) {
    let theEvent = evt || window.event;

    // Handle paste
    if (evt.type === 'paste') {
        key = event.clipboardData.getData('text/plain');
    } else {
        // Handle key press
        let key = evt.keyCode || evt.which;
        key = String.fromCharCode(key);
    }
    let regex = /[0-9]|\./;
    if( !regex.test(key) ) {
        evt.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }

    if(evt.target.value.length >= 11){
        evt.returnValue = false;
        if(theEvent.preventDefault) theEvent.preventDefault();
    }
}


function validaCliente(evt){
   /*
   * CPF
   * */
    CPF('cpf',evt)

    /*
   * Nome
   * */
    const nome = document.getElementById('nome')

    if(nome.value.length > 100){
        if(evt.preventDefault()) evt.preventDefault()
        alert("O campo nome deve ter no maximo 100 caracteres")
        nome.focus()
        return false
    }else if(nome.value === ""){
        if(evt.preventDefault()) evt.preventDefault()
        alert("o campo nome é de preenchimento obrigatorio")
        nome.focus()
        return false
    }


    /*
    * Data de Nascimento
    * */
    const nasci = document.getElementById("nascimento").value;
    let data_array = nasci.value.split("-");

    if(data_array[0].length !== 4){
        nasci.value = data_array[2]+"-"+data_array[1]+"-"+data_array[0];
    }

    // comparo as datas e calculo a idade
    let hoje = new Date();
    let nasc  = new Date(nasci);
    let idade = hoje.getFullYear() - nasc.getFullYear();
    let m = hoje.getMonth() - nasc.getMonth();
    if (m < 0 || (m === 0 && hoje.getDate() < nasc.getDate())) idade--
    if(idade < 0 || idade > 150){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('Data de nascimento invalida')
        nasc.focus()
        return false
    }

    /*
    * RG
    * */
    const rg = document.getElementById('rg')

    if(rg.value.length > 15){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo rg deve ter no maximo 15 caracteres')
        rg.focus()
        return false
    }

    /*
    * Orgão emissor
    * */
    const org = document.getElementById('orgao_emissor')

    if(org.value.length > 20){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo orgão emissor deve ter no maximo 20 caracteres')
        org.focus()
        return false
    }

    /*
    * E-mail
    * */
    Email(100,evt)

    /*
    * Telefone
    * */
    const tel = document.getElementById('telefone')

    if(tel.value.length > 20){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo telefone deve ter no maximo 20 caracteres')
        tel.focus()
        return false
    }else if(tel.value === ""){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('o campo telefone é de preenchimento obrigatorio')
        tel.focus()
        return false
    }

    /*
    * Logrdouro
    * */
    const log = document.getElementById('logradouro')

    if(log.value.length > 100){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo logradouro deve ter no maximo 100 caracteres')
        log.focus()
        return false
    }

    /*
    * Numero
    * */
    const num = document.getElementById('numero')
    if(num.value.length > 20){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo numero deve ter no maximo 20 caracteres')
        num.focus()
        return false
    }

    /*
    * Bairro
    * */
    const bair = document.getElementById('bairro')

    if(bair.value.length > 45){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo bairro deve ter no maximo 45 caracteres')
        bair.focus()
        return false
    }

    /*
    * Cidade
    * */
    const cid = document.getElementById('cidade')

    if(cid.value.length > 45){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo cidade deve ter no maximo 45 caracteres')
        cid.focus()
        return false
    }

    /*
    * Estado
    * */
    const est = document.getElementById('estado')

    if(est.value.length > 2){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo estado deve ter no maximo 2 caracteres')
        est.focus()
        return false
    }
}

const cliente = document.getElementById('formCliente')
if(cliente != null) cliente.addEventListener('submit', validaCliente)

/*
* Validações produto
* */

function validaProduto(evt){
    /*
    * Nome
    * */
    const nome = document.getElementById('nome')

    if (nome.value.length > 100) {
        if (evt.preventDefault) evt.preventDefault();
        window.alert('O campo nome deve ter no maximo 100 caracteres')
        nome.focus()
        return false
    }else if(nome.value === ''){
        if (evt.preventDefault) evt.preventDefault();
        window.alert('O campo nome é de preenchimetno obrigatio')
    }

    /*
    * Unidade
    * */
    const und = document.getElementById('unidade')

    if (und.value.length > 3) {
        if (evt.preventDefault) evt.preventDefault();
        window.alert('O campo unidade deve ter no maximo 100 caracteres')
        nome.focus()
        return false
    }else if(und.value === ''){
        if (evt.preventDefault) evt.preventDefault();
        window.alert('O campo und é de preenchimetno obrigatio')
        und.focus()
        return false
    }

    /*
    * Preço
    * */
    const preco = document.getElementById('preco_unitario')

    if (isNaN(preco.value)) {
        if (evt.preventDefault) evt.preventDefault();
        window.alert('O campo Preço deve recebe apenas numeros')
        preco.focus()
        return false
    }else if(preco.value === ''){
        if (evt.preventDefault) evt.preventDefault();
        window.alert('O campo nome é de preenchimetno obrigatio')
        preco.focus()
        return false
    }
}

const formProd = document.getElementById('formProduto')
if (formProd != null) formProd.addEventListener('submit', validaProduto)

/*
* Pedido
* */
function validaPedido(evt){

    const hoje = new Date();
    const hjString = hoje.getFullYear() + "-" + String((hoje.getMonth()+1)).padStart(2, '0') + "-" + hoje.getDate()


    /*
    * Data emissão
    * */
    const emis = document.getElementById('Data_Emissao')
    let dataEmis = new Date(emis.value)

    if(dataEmis > hoje){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('Data de emissão invalida')
        emis.focus()
        emis.value = hjString
        return false
    }else if(emis.value === ''){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('Data de emissão invalida')
        emis.focus()
        emis.value = hjString
        return false
    }

    /*
    * Valor do frete
    * */
    const frete = document.getElementById('Valor_Frete')

    if(frete.value === ''){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo valor do frete é de preenchimento obriatorio')
        frete.value = 0
        frete.focus()
        return false
    }else if(isNaN(frete.value)){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo frete aceita apenas numeros')
        frete.focus()
        return false
    }

    /*
    * Data de Entrega
    * */
    const entrega = document.getElementById('Data_Entrega')
    let dataEnt = new Date(entrega.value)

    if(dataEnt < dataEmis){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('Data de entrega invalida')
        entrega.value = hjString
        entrega.focus()
        return false
    }

    /*
    * Cliente
    * */
    const cliente = document.getElementById('Cliente_Id')

    if(cliente.value === ''){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo cliente é de preenchimento obrigatorio')
        cliente.focus()
        return false
    }
}

const formPedido = document.getElementById('formPedido')
if (formPedido != null) formPedido.addEventListener("submit", validaPedido)

/*
* Validações usuario
* */

function validaUsuario(evt){
    /*
    * CPF
    * */
    CPF('pk',evt)

    /*
    * Nome
    * */
    const nome = document.getElementById('nome')

    if(nome.value.length > 100){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo nome deve ter no maximo 100 caracteres')
        nome.focus()
        return false
    }else if(nome.value === ''){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo nome é de preenchimento obrigatorio')
        nome.focus()
        return false
    }

    /*
    * Nascimento
    * */
    const nasc = document.getElementById('nascimento')
    const hoje = new Date();
    const dataNasc = new Date(nasc.value)

    if(dataNasc > hoje){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('Data de nascimento invalida')
        nasc.value = ''
        nasc.focus()
        return false
    }

    /*
    * Email
    * */
    Email(45, evt)

    /*
    * Telefone
    * */
    const tel = document.getElementById('telefone')

    if(tel.value.length > 20){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo telefone deve tem um tamanho maximo de 20 caracteres')
        tel.focus()
        return false
    }

    /*
    * Username
    * */
    const user = document.getElementById('username')

    if(user.value.length > 15){
        // if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo username deve ter no maximo 15 caracteres')
        user.focus()
        return false
    }else if(user.value === ''){
        // if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo username é de preenchimento obrigatorio')
        user.focus()
        return false
    }

    /*
    * Senha
    * */
    const senha = document.getElementById('senha')

    if(senha.value.length > 255){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo senha deve ter no maximo 255 caracteres')
        user.focus()
        return false
    }else if(senha < 8){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo senha deve ter no minimo 8 caracteres')
        user.focus()
        return false
    }
}

const formUsuario = document.getElementById('formUsuario')
if(formUsuario != null) formUsuario.addEventListener("submit", validaUsuario)

const Email = (tm,evt) => {
    const email = document.getElementById('email')
    const filtro = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i

    if(email.value.length > tm){
        if(evt.preventDefault()) evt.preventDefault()
        window.alert('O campo email deve ter no maximo 100 caracteres')
        email.focus()
        return false
    }else if(email.value === ""){
        if(evt.preventDefault()) evt.preventDefault()
        alert("o campo email é de preenchimento obrigatorio")
        email.focus()
        return false
    }else if(!filtro.test(email.value)){
        if(evt.preventDefault()) evt.preventDefault()
        alert("Ops... Este e-mail parece ser inválido.");
        email.value = ""
        return false
    }
}

const CPF = (id, evt)=>{
    const cpf = document.getElementById(id)
    let regex = /[0-9]|\./;

    if(!regex.test(key) ) {
        if(evt.preventDefault) evt.preventDefault();
        window.alert('CPF invalido')
        cpf.focus()
        return false
    }else if(cpf.value.length > 11){
        if(evt.preventDefault) evt.preventDefault();
        window.alert('CPF invalido')
        cpf.focus()
        return false
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

    if (Valor_Frete === ''){
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


