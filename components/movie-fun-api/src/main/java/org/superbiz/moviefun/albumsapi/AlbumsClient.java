package org.superbiz.moviefun.albumsapi;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.client.RestOperations;

import java.util.List;

import static org.springframework.http.HttpMethod.GET;

public class AlbumsClient {


        private String albumsUrl;
        private RestOperations restOperations;

        private static ParameterizedTypeReference<List<AlbumInfo>> albumListType = new ParameterizedTypeReference<List<AlbumInfo>>() {
        };

        public AlbumsClient(String albumsUrl, RestOperations restOperations) {
            this.albumsUrl = albumsUrl;
            this.restOperations = restOperations;
        }

        public void addAlbum(AlbumInfo movie) {
            restOperations.postForEntity(albumsUrl, movie, AlbumInfo.class);
        }


        public AlbumInfo find(int id) {

            return restOperations.getForEntity(albumsUrl + "/" + id, AlbumInfo.class).getBody();
        }


        public List<AlbumInfo> getAlbums() {
            return restOperations.exchange(albumsUrl, GET, null, albumListType).getBody();
        }
    
    
}
