export const URL = "http://localhost:8080";

export const getApi = (path: string, params: string|null) => 
    fetch(`${URL}/${path}${params !== null ? params : ''}`,{
        mode: 'cors'
    })
    .then((res) => res.json())
    .catch((err) => Promise.reject(err))

export const postApi = (path: string, data: any) => 
    fetch(`${URL}/${path}`,{
        method:"POST",
        body: data
    })
    .then((res) => res.json())
    .catch((err) => Promise.reject(err))