"use strict";

// Simulate an HTTP Request
// url: the URL to "call"
// body: the body to send (if any)
// time: the time to wait before returning (if null, a random time between 10 and 30ms is used)
// success: if true, the request is successful, otherwise it fails
// debug: if true, debug information is printed to the console
// returns a Promise that resolves or rejects after the specified time

// The following URLs are supported:
// /price -> returns a random price
// /addtaxes -> returns the body * 1.23
// /students?size=200 -> returns an array of students (total = size parameter if present, 100 otherwise)
// /step.... -> returns the body value + 1 (used to simulate steps in a process)
// any_thing_else?a=1&b=2 -> returns {a:1, b:2}
// any_thing_else -> returns "OK"

let simulateHttpRequestGlobalCounter = 0;

const simulateHttpRequest = (url, body, time = null, success = true, debug = true) => {
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
                    resolve({"data" : Math.floor(Math.random() * 100 + 1)})
                } else if (url === 'addtaxes') {
                    resolve({"data" : body * 1.23})
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
                    resolve({"data" : createArrayOfStudents(size, true)})
                } else if (url.startsWith('step')) {
                    resolve({"data" : parseInt((body ?? 0) + 1)})
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
