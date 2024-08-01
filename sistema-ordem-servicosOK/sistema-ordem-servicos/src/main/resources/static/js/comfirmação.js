document.addEventListener('DOMContentLoaded', (event) => {
    const deleteLinks = document.querySelectorAll('a.delete-link');
    deleteLinks.forEach(link => {
        link.addEventListener('click', function(event) {
            const itemType = this.getAttribute('data-item-type'); // Obtém o tipo de item
            const userConfirmed = confirm(`Você tem certeza que deseja excluir este ${itemType}?`);
            if (!userConfirmed) {
                event.preventDefault(); // Impede a navegação se o usuário cancelar
            }
        });
    });
});
