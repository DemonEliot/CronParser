# CronParser

An application that parses a cron string and expands each field to show the times at which it will run.

## Usage

Can be run from command line/terminal like so:

java Cron args...

For example:

java Cron */15 0 1,15 \* 1-5 /usr/bin/find

Be aware, you may have to escape certain special characters for the command line to pass it in literally.
