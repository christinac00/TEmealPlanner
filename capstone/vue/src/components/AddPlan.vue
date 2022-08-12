<template>
  <form action="http://localhost:9000/users/:id/meal-plan" method="POST">
  <label for="plan-name">Plan Name: </label>
  <input name="plan-name" type="text" />
  <label for="day-of-week">What day is this plan for? </label>
  <select name="day-of-week" id="day-of-week">
      <option value="">--Choose a Day from the Dropdown Menu--</option>
      <option value="monday">Monday</option>
      <option value="tuesday">Tuesday</option>
      <option value="wednesday">Wednesday</option>
      <option value="thursday">Thursday</option>
      <option value="friday">Friday</option>
      <option value="saturday">Saturday</option>
      <option value="sunday">Sunday</option>
  </select>
  <input id="submit" type="submit">
  </form>
</template>

<script>
export default {
    name: "add-plan"
}
</script>

<style>

</style>