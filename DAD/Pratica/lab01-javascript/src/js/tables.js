// Function to display array data in a table
const showArrayOnTable = (tableId, array) => {
    const table = document.getElementById(tableId)
    table.innerHTML = "" // Clear previous content

    if (!array || array.length === 0) {
        table.innerHTML = "<tr><td>No data</td></tr>"
        return
    }

    const firstElement = array[0]
    let isObject = typeof firstElement === "object" && firstElement !== null && !Array.isArray(firstElement)

    // Create table header
    const thead = document.createElement("thead")
    const headerRow = document.createElement("tr")

    const indexHeader = document.createElement("th")
    indexHeader.textContent = "Index"
    headerRow.appendChild(indexHeader)

    if (isObject) {
        // Use object keys as headers
        Object.keys(firstElement).forEach(key => {
            const th = document.createElement("th")
            th.textContent = key
            headerRow.appendChild(th)
        })
    } else {
        const valueHeader = document.createElement("th")
        valueHeader.textContent = "Value"
        headerRow.appendChild(valueHeader)
    }

    thead.appendChild(headerRow)
    table.appendChild(thead)

    // Create table body
    const tbody = document.createElement("tbody")

    array.forEach((item, index) => {
        const row = document.createElement("tr")

        // First column = index
        const indexCell = document.createElement("td")
        indexCell.textContent = index
        row.appendChild(indexCell)

        if (isObject) {
            // Add object's property values
            Object.keys(firstElement).forEach(key => {
                const cell = document.createElement("td")
                cell.textContent = item[key]
                row.appendChild(cell)
            })
        } else {
            // Add value as string
            const valueCell = document.createElement("td")
            valueCell.textContent = item
            row.appendChild(valueCell)
        }

        tbody.appendChild(row)
    })

    table.appendChild(tbody)
}

// Function to display object properties in a table
const showObjectOnTable = (tableId, obj) => {
    const table = document.getElementById(tableId)
    table.innerHTML = "" // Clear previous content

    if (!obj || typeof obj !== "object") {
        table.innerHTML = "<tr><td>No object data</td></tr>"
        return
    }

    const keys = Object.getOwnPropertyNames(obj)
    if (keys.length === 0) {
        table.innerHTML = "<tr><td>No properties</td></tr>"
        return
    }

    // Create table header
    const thead = document.createElement("thead")
    const headerRow = document.createElement("tr")

    const nameHeader = document.createElement("th")
    nameHeader.textContent = "Property/Method"
    headerRow.appendChild(nameHeader)

    const valueHeader = document.createElement("th")
    valueHeader.textContent = "Value"
    headerRow.appendChild(valueHeader)

    thead.appendChild(headerRow)
    table.appendChild(thead)

    // Create table body
    const tbody = document.createElement("tbody")

    keys.forEach(key => {
        const row = document.createElement("tr")
        const nameCell = document.createElement("td")
        nameCell.textContent = key
        row.appendChild(nameCell)

        const valueCell = document.createElement("td")
        try {
            const value = obj[key]
            if (typeof value === "function") {
                valueCell.textContent = "[Function]"
            } else {
                valueCell.textContent = value
            }
        } catch (e) {
            valueCell.textContent = "[Error]"
        }
        row.appendChild(valueCell)
        tbody.appendChild(row)
    })

    table.appendChild(tbody)
}
