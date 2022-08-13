import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    getAllRecipes() {
        return http.get('/recipes');
    },
    getDetails(recipeId) {
        return http.get(`recipes/${recipeId}`);
    },
    createRecipe(recipe) {
        return http.post('/recipes', recipe);
    },
    updateRecipe(recipe) {
        return http.put(`/recipes/${recipe.Id}`, recipe);
    },
    getMyRecipes(id) {
        return http.get(`users/${id}/recipes`)
    },
    createPlan(id) {
        return http.post(`users/${id}/plan`)
    },
    createUserRecipe(userId, recipeId){
        return http.post(`users/${userId}/recipes/${recipeId}`)
    }
    
}