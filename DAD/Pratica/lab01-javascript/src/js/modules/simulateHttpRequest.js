import { createArrayOfStudents } from './students.js' // import nomeado: chaves e o nome exato da função exportada

let simulateHttpRequestGlobalCounter = 0;

export default (url, body, time = null, success = true, debug = true) => { // export default: a função principal do módulo, sem nome
    return new Promise((resolve, reject) => {
        let simulateHttpRequestLocalCounter = ++simulateHttpRequestGlobalCounter;
        time = time ?? Math.floor(Math.random() * 20 + 10)
        if (debug) {
            console.log(` -> (${simulateHttpRequestLocalCounter}) Sending HTTP Request - simulated HTTP Request (success = ${success}) (time = ${time} ms) (url = ${url})`)
        }
        setTimeout(() => {
            if (success) {
                if (debug) {
                    console.log(` <- (${simulateHttpRequestLocalCounter}) Receiving HTTP Response SUCCESS - simulated HTTP Request (time = ${time} ms) (url = ${url})`)
                }
                if (url === 'price') {
                    resolve({ "data": Math.floor(Math.random() * 100 + 1) })
                } else if (url === 'addtaxes') {
                    resolve({ "data": body * 1.23 })
                } else if (url.startsWith('students')) {
                    let size = 100; // default size
                    let idx = url.indexOf('?')
                    if (idx >= 0) {
                        let params = url.substring(idx + 1).split('&')
                        let obj = {}
                        for (let p of params) {
                            let kv = p.split('=')
                            obj[kv[0]] = kv[1]
                        }
                        if (obj.size) {
                            size = parseInt(obj.size)
                        }
                    }
                    resolve({ "data": createArrayOfStudents(size, true) })
                } else if (url.startsWith('step')) {
                    resolve({ "data": parseInt((body ?? 0) + 1) })
                } else {
                    let idx = url.indexOf('?')
                    if (idx >= 0) {
                        let params = url.substring(idx + 1).split('&')
                        let obj = {}
                        for (let p of params) {
                            let kv = p.split('=')
                            obj[kv[0]] = kv[1]
                        }
                        resolve({ "data": obj })
                    } else {
                        resolve({ "data": "OK" })
                    }
                }
            } else {
                if (debug) {
                    console.log(` <- (${simulateHttpRequestLocalCounter}) Receiving HTTP Response ERROR - simulated HTTP Request (time = ${time} ms) (url = ${url})`)
                }
                reject(Error("HTTP Response from " + url + " is an ERROR"))
            }
        }, time)
    })
}