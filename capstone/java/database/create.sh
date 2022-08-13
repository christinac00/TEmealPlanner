#!/bin/bash
export PGPASSWORD='postgres1'
BASEDIR=$(dirname $0)
DATABASE=final_capstone
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/recipes.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/ingredients.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/recipe-ingredient.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/user-recipe.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/downloaded-recipes.sql"