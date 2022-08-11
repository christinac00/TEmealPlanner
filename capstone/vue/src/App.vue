<template>
  <div id="app">
    
    <router-view class="view"/>
  </div>
</template>


<script>
export default {
  name: "home"
};
</script>
<style>

.left-panel {
display: flex;
flex-basis: 35%;
flex-direction: column;
width: 448px;
height: 1029px;
left: 0px;
top: 0px;
 
background: #7e2d73;
}
.navbar {
  position: absolute;
width: 548px;
height: 80px;
right: 0px;
top: 0px;
text-align: center;
 
background:#2c5e97;
}
ul {
  align-items: right;
}
header {
position: absolute;
width: 992px;
height: 240px;
left: 448px;
top: 0px;
text-align: center;
 
background: #FFE473;
}

.recipes{
  padding: 40px 55px;
  margin: 15px 0;
  background-color: #00AFEF;
  color: #fff;
  border: solid 1px #777;
  display: flex;

}
.social-icons {
  display: flex;
  justify-content: space-between;
  list-style-type: none;
  margin: 20px 20px;
  padding: 0;
}
.app{
  display: grid;
  grid-template-areas: 'app';
}
.view {
grid-area: app;
}
</style>




