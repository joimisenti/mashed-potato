// An array to store selected perks
const selectedPerks = [];

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

            // Event listeners to handle perk selection
            selectButton.addEventListener('click', () => {
                if (selectedPerks.length < 4) {
                    // Check if the perk is not already in the selectedPerks list
                    if (!selectedPerks.some(selectedPerk => selectedPerk.id === perk.id)) {
                        selectedPerks.push(perk);
                        updateSelectedPerks();
                    } else {
                        alert('This perk is already selected.');
                    }
                } else {
                    // Handle case where maximum perks are selected
                    alert('You can select up to 4 perks.')
                }
            });

            perkItem.appendChild(selectButton);

            document.querySelector('.perk-grid').appendChild(perkItem);
        });
    });
}

// Function to toggle the selection of a perk
function updateSelectedPerks() {
    // Implement logic allowing selection of up to 4 perks
    // Add or remove the perk from the "Selected Perks" list
    const selectedPerksList = document.getElementById('selected-perks-list');
    selectedPerksList.innerHTML = ''; // Clear the previous selections

    // Loop through selected perks and create list items
    selectedPerks.forEach(perk => {
        const listItem = document.createElement('li');
        listItem.textContent = perk.name;

        const listIcon = document.createElement('img');
        listIcon.src = perk.image;
        listItem.appendChild(listIcon);

        // Add a button to remove the perk from the selection
        const removeButton = document.createElement('button');
        removeButton.textContent = 'Remove';
        removeButton.addEventListener('click', () => {
            selectedPerks.splice(selectedPerks.indexOf(perk), 1);
            updateSelectedPerks();
        });

        listItem.appendChild(removeButton);
        selectedPerksList.appendChild(listItem);
    });
}

// Call fetchPerks function when the page loads
window.addEventListener('load', fetchPerks);