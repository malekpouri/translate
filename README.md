## README for Groovy Subtitle Translation Program

**Project Name:** Groovy Subtitle Translator

**Description:**

This program is a tool for translating subtitles from one language to another using the Groovy programming language. It supports various subtitle formats, including VTT, SRT, and ASS, and can integrate with translation APIs or services to provide accurate and efficient translations.

**Features:**

* Translates subtitles from one language to another
* Supports various subtitle formats (VTT, SRT, ASS)
* Integrates with translation APIs or services
* Command-line interface for easy usage
* Customizable translation settings

**Installation:**

1. Clone the repository:

```bash
git clone https://github.com/malekpouri/translate.git
```

2. Install dependencies:

```bash
cd translate
gradle install
```

**Usage:**

1. Run the program with the following command:

```bash
gradle run -PsourceLang=SOURCE_LANGUAGE -PtgtLang=TARGET_LANGUAGE -PsubtitleFile=PATH_TO_SUBTITLE_FILE
```

Replace `SOURCE_LANGUAGE`, `TARGET_LANGUAGE`, and `PATH_TO_SUBTITLE_FILE` with the appropriate values.

2. The translated subtitles will be saved to the specified output file.

**Example:**

```bash
gradle run -PsourceLang=en -PtgtLang=fa -PsubtitleFile=input.srt
```

This command will translate the subtitles in `input.srt` from English to Farsi and save the translated subtitles to `output.srt`.

**Customization:**

The program can be customized by modifying the `config.properties` file. This file allows you to specify the translation API key, output file format, and other settings.

**Contributing:**

We welcome contributions to this project. Please feel free to fork the repository, make changes, and submit pull requests.

**License:**

This project is licensed under the MIT License.

**Contact:**

If you have any questions or suggestions, please feel free to contact us at m.malekpoor@gmail.com.
