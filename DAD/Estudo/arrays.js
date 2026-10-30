const buildArray = (total, random = false, min = 1, max = 100) => {
    const array = []
    for (let current = 0; current < total; current++) {
        if (random) {
            array.push(Math.floor(Math.random() * (max - min + 1)) + min)
        } else {
            array.push(min + current)
        }
    }
    return array
}

const buildRandomArray = (total) => {
    let array = []
    for (let i = 0; i < total; i++) {
        array.push(Math.floor(Math.random() * 21))
    }
    return array
}

let array = buildArray(5)

let randomArray = buildRandomArray(20);

for (let element of array) {
    console.log(element);
}

console.log(array);

console.log(randomArray);

array.push(6)
array.unshift(0)

console.log(array);
console.log(array.length);

array.pop()
array.shift()

console.log(array);
console.log(array.length);

console.clear();

randomArray.sort()
console.log(randomArray);

let arr = [6,5,4,3,2,1, 10, 20 , 30]
console.log(arr.sort());


