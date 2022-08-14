import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:9000"
})

export default {
    newMealPlan(id) {
        return http.post(`/users/${id}/meal-plans`, id)
    },
    getPlanById(id, planId) {
        return http.get(`/users/${id}/meal-plans/${planId}`)
    },
    getAllMealPlans(id) {
        return http.get(`/users/${id}/meal-plans`)
    },
    updateMealPlan(id, planId) {
        return http.put(`/users/${id}/meal-plans/${planId}`)
    },
    deleteMealPlan(id, planId) {
        return http.delete(`/users/${id}/meal-plans/${planId}`)
    }
}