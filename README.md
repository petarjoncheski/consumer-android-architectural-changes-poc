### About ###

The main purpose of this repo is to try out the new architectural concepts and libraries that should be implemented at the android storefront application.

### Things to be implemented in this project ###

- Home screen with a BNV(BottomNavigationView). Clicking on a item from the BNV that will switch between Fragments that are inside a ViewPager.
- ViewModels that extends from android architecture components.
- Tests for the ViewModels.
- Implement DI. [Dagger](https://dagger.dev/) is the most commonly used but we can also take [Koin](https://insert-koin.io/) in consideration which is written in pure kotlin and more lightweight.

### Things to bear in mind when contributing to this repo ###

- How the code in this project will be implemented at the android storefront codebase.
- The instances of the classes in this project should be ready to be provided with DI(Dependency Injection) in the future.
- The ViewModels should be easily tested.
- The Fragments and ViewModels should be independent from the activity as much as possible.
- No Android Views inside the ViewModels!


**If you can think of more things to be implemented or taken into consideration, feel free to update this file.**