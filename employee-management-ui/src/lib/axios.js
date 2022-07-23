import axios from "axios";

const api = axios.create();


export const axiosGet = async (url, parameters) => {
    const res = await api.get(url, {
        params: { ...parameters },
    })
        .catch((error) => {
            console.log('here');
            if (!error.response) {
                error.errorMessage = 'Something went wrong. Please contant a System Administrator';
            } else {
                error.errorMessage = error.response.data.errorMessage;
            }
            throw error;
        })


    return res;
};


export const axiosPost = async (url, data) => {
    const res = await api.post(url, data)
        .catch((error) => {
            if (!error.response) {
                error.errorMessage = 'Something went wrong. Please contant a System Administrator';
            } else {
                error.errorMessage = error.response.data.errorMessage;
            }
            throw error;
        })

    return res;
};


export const axiosPut = async (url, data) => {
    return await api.put(url, data)
        .catch((error) => {
            if (!error.response) {
                error.errorMessage = 'Something went wrong. Please contant a System Administrator';
            } else {
                error.errorMessage = error.response.data.errorMessage;
            }
            throw error;
        })
};


export const axiosDelete = async (url) => {
    return await api.delete(url)
        .catch((error) => {
            if (!error.response) {
                error.errorMessage = 'Something went wrong. Please contant a System Administrator';
            } else {
                error.errorMessage = error.response.data.errorMessage;
            }
            throw error;
        })
};