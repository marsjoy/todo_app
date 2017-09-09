# Pre-work - *Simple Todo App*

**Simple Todo App** is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: **Mars Williams**

Time spent: **10** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:

* [ ] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [ ] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item)
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [ ] Add support for selecting the priority of each todo item (and display in listview item)
* [ ] Tweak the style improving the UI / UX, play with colors, images or backgrounds

The following **additional** features are implemented:

* [ ] List anything else that you can get done to improve the app functionality!

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://i.imgur.com/aosIFff.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** As someone who previously was a data engineer, I don't have any experience building with platforms that have layouts and interfaces (excepting terminal as an interface). I did find it relatively straightforward to work within Android Studio, and am surprised that you can drag and drop ui components, and that they are coded efficiently. This is very different than in the days of DreamWeaver, when a dragged component generated reams of bloated code. 

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** The ArrayAdapter in the ToDo App served to bind the View objects to the task descriptions, each contained as a item in the ListView collection. The Adapter is important because it is a way to interact with view objects, without needing to be concerned about the specific bind mechanism for each collection type. The convertView method allows the ArrayAdapter to recycle old view objects that are no longer in use (like the deleted todo tasks), to improve performance of the app; this is in contrast to creating new view objects to replace ones that are removed. The getView method gets the view of an item's data at the specific position in the collection. 

## Notes

Describe any challenges encountered while building the app.

My greatest challenge while building the app was keeping the iterations small, and remembering to scale down complexity. Originally, I made the whole app, with a persistent database, a custom adapter, and several model classes, but when I encountered bugs, it was difficult to entangle the working parts to find the source.

## License

    Copyright [2017] [Mars Williams]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.