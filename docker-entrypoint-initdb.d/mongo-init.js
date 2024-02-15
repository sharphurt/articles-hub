console.log("START INITIALIZING")

db = db.getSiblingDB('articles-hub-prod');
db.createUser(
  {
    user: 'sharphurt',
    pwd: 'password',
    roles: [{ role: 'readWrite', db: 'articles-hub-prod' }],
  },
);
db.createCollection('articles');

db = db.getSiblingDB('articles-hub-test');
db.createUser(
  {
    user: 'sharphurt',
    pwd: 'password',
    roles: [{ role: 'readWrite', db: 'articles-hub-test' }],
  },
);
db.createCollection('articles');

console.log("STOP INITIALIZING")
