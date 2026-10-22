const courseNames = [
    "Mathematics", "Physics", "Computer Science", "Electronics"
]

const disciplineNames = [
    "Mathematics", "Physics", "Chemistry", "Biology", "History", "Geography", "English", "Computer Science"
]

const englishFirstNames = [
    "James", "Mary", "John", "Patricia", "Robert", "Jennifer", "Michael", "Linda", "William", "Elizabeth",
    "David", "Susan", "Richard", "Jessica", "Joseph", "Sarah", "Charles", "Karen", "Thomas", "Nancy",
    "Christopher", "Betty", "Daniel", "Margaret", "Matthew", "Sandra", "Anthony", "Ashley", "Donald", "Dorothy",
    "Mark", "Helen", "Paul", "Ruth", "Steven", "Sharon", "Andrew", "Michelle", "Kenneth", "Laura",
    "Joshua", "Deborah", "Kevin", "Betty", "Brian", "Helen", "George", "Amy", "Edward", "Anna"
]

const englishLastNames = [
    "Smith", "Jones", "Williams", "Taylor", "Brown", "Davies", "Evans", "Wilson", "Thomas", "Johnson",
    "Roberts", "Robinson", "Thompson", "Wright", "Walker", "White", "Edwards", "Hughes", "Green", "Hall",
    "Lewis", "Harris", "Martin", "Clarke", "Jackson", "Scott", "Miller", "Moore", "King", "Lee",
    "Adams", "Baker", "Carter", "Cooper", "Dixon", "Foster", "Graham", "Gray", "Harrison", "Hunt",
    "James", "Kingston", "Lawrence", "Morris", "Nelson", "Parker", "Robinson", "Stewart", "Taylor", "Ward"
]

export const createRandomStudentObject = () => {
    return {
        id: '25' +
            (Math.floor(Math.random() * (999999 - 100000 + 1)) + 100000),
        name: getRandomFullName(),
        grade: Math.floor(Math.random() * 21)
    }
}

export const createRandomStudentWithCourseObject = () => {
    return {
        id: '25' +
            (Math.floor(Math.random() * (999999 - 100000 + 1)) + 100000),
        name: getRandomFullName(),
        grade: Math.floor(Math.random() * 21),
        course: courseNames[Math.floor(Math.random() * courseNames.length)]
    }
}

export const createArrayOfStudents = (size, includeCourse = false) => { /** @type {{ id: string, name: string, grade: number, course?: string }[]} */
    const array = []
    for (let i = 0; i < size; i++) {
        if (includeCourse) {
            array.push(createRandomStudentWithCourseObject())
        } else {
            array.push(createRandomStudentObject())
        }
    }
    return array
}

const getRandomFullName = () => {
    const first = englishFirstNames[Math.floor(Math.random() * englishFirstNames.length)];
    const last = englishLastNames[Math.floor(Math.random() * englishLastNames.length)];
    return `${first} ${last}`;
}