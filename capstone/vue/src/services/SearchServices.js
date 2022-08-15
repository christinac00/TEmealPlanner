import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    searchByTag(keyword) {
        return http.get('/search/', keyword)
    
    },
    searchByIngredient(ingredientName) {
        return http.get('/search/', ingredientName)
    }
}