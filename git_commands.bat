@echo off
echo Setting up Git repository and pushing to GitHub...

git init
git config user.name "Vishalcj3"
git config user.email "vishal.cj.cbe@gmail.com"

git add .
git commit -m "Initial commit: Backend Project"
git branch -M main
git remote add origin https://github.com/Vishalcj3/backend-project.git
git push -u origin main

echo Done! Repository pushed to GitHub.
pause