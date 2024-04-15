## README for Subtitle Translation Script

**Project:** Groovy Subtitle Translator

**Description:**

This script is a tool for translating subtitles from one language to another using the Groovy programming language. It utilizes the Webtran.eu translation service to provide accurate translations for various subtitle formats, including SRT, VTT, and ASS.

**Features:**

* Translates subtitles from one language to another
* Supports multiple subtitle formats (SRT, VTT, ASS)
* Utilizes Webtran.eu for efficient translation
* Handles multiple subtitle files in a directory
* Customizable language settings

**Installation:**

1. Install Groovy: [https://groovy-lang.org/](https://groovy-lang.org/)
2. Save the script as `Main.groovy`

**Usage:**

```bash
groovy Main.groovy /path/to/subtitles/directory [firstLanguage] [secondLanguage]
```

Replace `/path/to/subtitles/directory` with the path to the directory containing the subtitle files.

**Example:**

```bash
groovy Main.groovy /home/user/subtitles en fa
```

This will translate all subtitle files in `/home/user/subtitles` from English to Farsi and save the translated files in the same directory.

**Customization:**

The script can be customized by modifying the `System.getProperties()` section to specify proxy settings if necessary.

**Contributing:**

We welcome contributions to this project. Feel free to fork the repository, make changes, and submit pull requests.

**License:**

This project is licensed under the MIT License.

**Contact:**

If you have any questions or suggestions, please feel free to contact us at [m.malekpoor@gmail.com](m.malekpoor@gmail.com).

**Additional Notes:**

* The script utilizes Webtran.eu for translation. You may need to create a free account and obtain an API key if you plan to translate a large number of files.
* The script handles multiple subtitle files in a directory. You can specify a single file or an entire directory.
* The script supports language customization. You can specify the source and target languages as command-line arguments. If no languages are specified, English and Farsi are used as defaults.
* The script saves translated files in the same directory as the original files, with a "_translate" suffix appended to the filename.

This script provides a convenient tool for translating subtitle files using Groovy and Webtran.eu. Feel free to modify and adapt it to your specific needs and contribute to its improvement.
