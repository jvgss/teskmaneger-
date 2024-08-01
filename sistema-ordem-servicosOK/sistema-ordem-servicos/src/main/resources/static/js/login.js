
function handleLogin(event) {
    event.preventDefault(); // Prevent the form from submitting the traditional way
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Dummy check for username and password
    if (username === 'admin' && password === 'joao101') {
        window.location.href = '/indice.html'; // Redirect to the index page
    } else {
        alert('Usuário ou senha incorretos');
    }
}
