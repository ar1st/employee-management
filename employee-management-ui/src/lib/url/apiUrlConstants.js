
const BASE_URL = 'http://localhost:8080/api'

export const GET_ATTRIBUTES_URL = `${BASE_URL}/attributes`
export const GET_ATTRIBUTE_URL = (id) => `${BASE_URL}/attributes/${id}`
export const POST_ATTRIBUTES_URL = `${BASE_URL}/attributes`
export const PUT_ATTRIBUTE_URL = (id) => `${BASE_URL}/attributes/${id}`
export const DELETE_ATTRIBUTE_URL = (id) => `${BASE_URL}/attributes/${id}`

export const GET_EMPLOYEES_URL = `${BASE_URL}/employees`