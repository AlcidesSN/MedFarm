const card = document.querySelectorAll('.card');

for (let i = 0; i < card.length; i++) {
    card.item(i).addEventListener('mouseover', () => {
        card.item(i).style.boxShadow = '0 5px 10px rgba(0, 0, 0, 0.5)';
    });

    card.item(i).addEventListener('mouseout', () => {
        card.item(i).style.boxShadow = '0 2px 5px rgba(0, 0, 0, 0.3)';
    });
}
