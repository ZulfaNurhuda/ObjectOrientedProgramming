import java.util.Scanner;

/**
 * MediaPlayer - Main class untuk testing PP4-1 MediaPlayer
 * Program ini akan membaca input dan melakukan operasi sesuai perintah
 */
public class MediaPlayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Variables untuk menyimpan objek media
        Movie movie = null;
        Podcast podcast = null;
        LiveStream liveStream = null;

        while (scanner.hasNextLine()) {
            String command = scanner.nextLine().trim();

            if (command.isEmpty()) continue;

            String[] parts = command.split(" ", 2);
            String action = parts[0];

            try {
                switch (action) {
                    case "CREATE_MOVIE":
                        String[] movieParams = parts[1].split(",");
                        String title = movieParams[0].trim();
                        int duration = Integer.parseInt(movieParams[1].trim());
                        long fileSize = Long.parseLong(movieParams[2].trim());
                        String genre = movieParams[3].trim();
                        movie = new Movie(title, duration, fileSize, genre);
                        System.out.println("Movie created: " + title);
                        break;

                    case "CREATE_PODCAST":
                        String[] podcastParams = parts[1].split(",");
                        String podTitle = podcastParams[0].trim();
                        int podDuration = Integer.parseInt(podcastParams[1].trim());
                        String host = podcastParams[2].trim();
                        int episode = Integer.parseInt(podcastParams[3].trim());
                        podcast = new Podcast(podTitle, podDuration, host, episode);
                        System.out.println("Podcast created: " + podTitle);
                        break;

                    case "CREATE_LIVESTREAM":
                        String[] liveParams = parts[1].split(",");
                        String liveTitle = liveParams[0].trim();
                        String streamer = liveParams[1].trim();
                        int viewers = Integer.parseInt(liveParams[2].trim());
                        boolean isLive = Boolean.parseBoolean(liveParams[3].trim());
                        liveStream = new LiveStream(liveTitle, streamer, viewers, isLive);
                        System.out.println("LiveStream created: " + liveTitle);
                        break;

                    case "MOVIE_PLAY":
                        if (movie != null) movie.play();
                        break;

                    case "MOVIE_PAUSE":
                        if (movie != null) movie.pause();
                        break;

                    case "MOVIE_STOP":
                        if (movie != null) movie.stop();
                        break;

                    case "MOVIE_GET_DURATION":
                        if (movie != null) System.out.println("Duration: " + movie.getDuration());
                        break;

                    case "MOVIE_GET_TITLE":
                        if (movie != null) System.out.println("Title: " + movie.getTitle());
                        break;

                    case "MOVIE_IS_PLAYING":
                        if (movie != null) System.out.println("Playing: " + movie.isPlaying());
                        break;

                    case "MOVIE_START_DOWNLOAD":
                        if (movie != null) System.out.println("Download started: " + movie.startDownload());
                        break;

                    case "MOVIE_GET_PROGRESS":
                        if (movie != null) System.out.println("Progress: " + movie.getDownloadProgress() + "%");
                        break;

                    case "MOVIE_CANCEL_DOWNLOAD":
                        if (movie != null) movie.cancelDownload();
                        break;

                    case "MOVIE_GET_FILE_SIZE":
                        if (movie != null) System.out.println("File size: " + movie.getFileSize());
                        break;

                    case "MOVIE_IS_COMPLETE":
                        if (movie != null) System.out.println("Download complete: " + movie.isDownloadComplete());
                        break;

                    case "MOVIE_GET_PATH":
                        if (movie != null) System.out.println("Path: " + movie.getDownloadPath());
                        break;

                    case "MOVIE_GET_GENRE":
                        if (movie != null) System.out.println("Genre: " + movie.getGenre());
                        break;

                    case "PODCAST_PLAY":
                        if (podcast != null) podcast.play();
                        break;

                    case "PODCAST_PAUSE":
                        if (podcast != null) podcast.pause();
                        break;

                    case "PODCAST_STOP":
                        if (podcast != null) podcast.stop();
                        break;

                    case "PODCAST_GET_DURATION":
                        if (podcast != null) System.out.println("Duration: " + podcast.getDuration());
                        break;

                    case "PODCAST_GET_TITLE":
                        if (podcast != null) System.out.println("Title: " + podcast.getTitle());
                        break;

                    case "PODCAST_IS_PLAYING":
                        if (podcast != null) System.out.println("Playing: " + podcast.isPlaying());
                        break;

                    case "PODCAST_START_DOWNLOAD":
                        if (podcast != null) System.out.println("Download started: " + podcast.startDownload());
                        break;

                    case "PODCAST_GET_PROGRESS":
                        if (podcast != null) System.out.println("Progress: " + podcast.getDownloadProgress() + "%");
                        break;

                    case "PODCAST_CANCEL_DOWNLOAD":
                        if (podcast != null) podcast.cancelDownload();
                        break;

                    case "PODCAST_GET_FILE_SIZE":
                        if (podcast != null) System.out.println("File size: " + podcast.getFileSize());
                        break;

                    case "PODCAST_IS_COMPLETE":
                        if (podcast != null) System.out.println("Download complete: " + podcast.isDownloadComplete());
                        break;

                    case "PODCAST_GET_PATH":
                        if (podcast != null) System.out.println("Path: " + podcast.getDownloadPath());
                        break;

                    case "PODCAST_GET_HOST":
                        if (podcast != null) System.out.println("Host: " + podcast.getHost());
                        break;

                    case "PODCAST_GET_EPISODE":
                        if (podcast != null) System.out.println("Episode: " + podcast.getEpisodeNumber());
                        break;

                    case "LIVE_PLAY":
                        if (liveStream != null) liveStream.play();
                        break;

                    case "LIVE_PAUSE":
                        if (liveStream != null) liveStream.pause();
                        break;

                    case "LIVE_STOP":
                        if (liveStream != null) liveStream.stop();
                        break;

                    case "LIVE_GET_DURATION":
                        if (liveStream != null) System.out.println("Duration: " + liveStream.getDuration());
                        break;

                    case "LIVE_GET_TITLE":
                        if (liveStream != null) System.out.println("Title: " + liveStream.getTitle());
                        break;

                    case "LIVE_IS_PLAYING":
                        if (liveStream != null) System.out.println("Playing: " + liveStream.isPlaying());
                        break;

                    case "LIVE_IS_LIVE":
                        if (liveStream != null) System.out.println("Is live: " + liveStream.isLive());
                        break;

                    case "LIVE_GET_STREAMER":
                        if (liveStream != null) System.out.println("Streamer: " + liveStream.getStreamerName());
                        break;

                    case "LIVE_GET_VIEWERS":
                        if (liveStream != null) System.out.println("Viewers: " + liveStream.getViewerCount());
                        break;

                    case "LIVE_UPDATE_VIEWERS":
                        if (liveStream != null) liveStream.updateViewerCount();
                        break;

                    case "LIVE_END_STREAM":
                        if (liveStream != null) liveStream.endStream();
                        break;

                    case "EXIT":
                        return;

                    default:
                        System.out.println("Unknown command: " + action);
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
