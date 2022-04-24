# TTRPG Character Creator

A Tabletop RPG character creator / character sheet.

This is an app I decided to build to help me learn Android App creation, and is
not meant as a serious app for use outside my own.

## Flow

The user starts up on the main page showing their list of characters. Diagram:

```
  Character List  <menu>
--------------------
 +-------+--------+
 |  Joe  |  Jack  |
 +-------+  Hack  |
 |       +--------+
 |  Img  |        |
 |       |   Img  |
 +-------+        |
 | FATE  +--------+
 +-------+ D&D 5e |
         +--------+
		       ( + )
```

- If they have none, display "Create a character to get started"
- The characters should be in a grid view, offset if they are varying sizes.
- Clicking on a character should bring you to the sheet view
- A new button will always be hovering in the bottom right
- Settings will be available via a menu
- Long pressing will enable a view where you can re-arrange the data, delete
  sheets, or make a duplicate.

### New Page
```
  Choose the type of the sheet:
  +---------------------------+
  | Sheet Type                |
  | D&D 5E                  V |
  +---------------------------+
  
  Character Name: _____________
  
  Character Image
  +----------------------------+
  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  |                            |
  +----------------------------+
  
  [ Create ]
```

- Sheet type is a dropdown listing supported sheet types
- Character name is the name of the character to display in the list
- Character Image is an image to set for a character

Character sheets to support:
- D&D 5E
- FATE

Once Create is pressed, move on to a sheets edit view. A sheets edit view should
always have a link to edit these fields.

### Settings page
```
+---------------+
| Default sheet |
| D&D 5E      V |
+---------------+
```

Settings page for now will just let you change the default sheet (what is
selected in the character screen)

### Character Sheet EDIT PAGE

Character sheet edit pages are based on the system
- These are custom added by hand right now. If we wanted to support many, we
  would have to add some form of templating system.
- Floating Save button, no auto save.. for now.
- Button to get back the new screen data to change that.

### Character Sheet VIEW PAGE

This will be a version of the edit page where the data cannot be edited, but
will be displayed.

Floating button to switch to Edit

From menu dropdown, can delete the sheet.

## Data storage

Data is stored on the device, for now no interest in making this a web database.

A Database is used, with the following design:

- CharacterImage (List of character image file system paths to ids)
- SheetSummaries
  + Id
  + Link to CharacterImage
  + Sheet Type <String mapping to Enum in code>
  + Name <String>
- SheetData
  + SheetId
  + DataFieldId
  + DataString
  + DataDouble

Sheet Data is used to store the arbitary sheet data as a key value store. The
Data can either be stored as a String or Double.