
    document.getElementById('contactForm').addEventListener('submit', function(event) {
        event.preventDefault(); // Impede o envio padrão do formulário

        const formData = {
            nome: document.getElementById('nome').value,
            email: document.getElementById('email').value,
            mensagem: document.getElementById('mensagem').value
        };

        fetch('/api/contact', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => {
            if (response.ok) {
                console.log('Mensagem enviada com sucesso!');
                alert('Sua mensagem foi enviada com sucesso!');
            } else {
                console.error('Erro ao enviar a mensagem.');
                alert('Ocorreu um erro ao enviar sua mensagem.');
            }
        })
        .catch(error => {
            console.error('Erro:', error);
            alert('Ocorreu um erro ao enviar sua mensagem.');
        });
    });
