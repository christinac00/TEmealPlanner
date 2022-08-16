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
        return http.put(`/recipes/${recipe.recipeId}`, recipe);
    },
    getMyRecipes(id) {
        return http.get(`users/${id}/recipes`)
    },
    createUserRecipe(userId, recipeId){
        return http.post(`users/${userId}/recipes/${recipeId}`)
    },
    getFilteredRecipes(search, searchTag) {
        if(search && searchTag) {
            return http.get(`/recipes?ingredient=${search}&tag=${searchTag}`);
        } else if(search) {
            return http.get(`/recipes?ingredient=${search}`);
        } else if(searchTag) {
            return http.get(`/recipes?tag=${searchTag}`);
        }
        return http.get('/recipes');
    },
    deleteIngredient(recipeId, ingredientId){
        return http.delete(`/recipes/${recipeId}/ingredient/${ingredientId}`)
    },
    addIngredientToRecipe(recipeId, ingredientId){
        return http.post(`/recipes/${recipeId}/ingredient/${ingredientId}`)
    }
    
}