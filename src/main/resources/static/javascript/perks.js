// Function to fetch perks from Spring Boot API
function fetchPerks() {
    fetch('/api/v1/perks')
    .then(response => response.json())
    .then(data => {
        console.log(data);
        // Loop through the perks to create HTML elements
        data.forEach(perk => {
            const perkItem = document.createElement('div');
            perkItem.classList.add('perk-item');

            const perkIcon = document.createElement('img');
            perkIcon.src = perk.image;
            perkItem.appendChild(perkIcon);

            const perkName = document.createElement('p');
            perkName.textContent = perk.name;
            perkItem.appendChild(perkName);

            const selectButton = document.createElement('button');
            selectButton.textContent = 'Select';
            selectButton.addEventListener('click', () => toggleSelectPerk(perk));
            perkItem.appendChild(selectButton);

            document.querySelector('.perk-grid').appendChild(perkItem);
        });
    });
}

// Function to toggle the selection of a perk
function toggleSelectPerk(perk) {
    // Implement logic allowing selection of up to 4 perks
    // Add or remove the perk from the "Selected Perks" list
}

// Call fetchPerks function when the page laods
window.addEventListener('load', fetchPerks);