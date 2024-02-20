package tech.buildrun.github.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.buildrun.github.client.GithubClient;
import tech.buildrun.github.client.RepositoryResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ApiController {

    private final GithubClient githubClient;

    public ApiController(GithubClient githubClient) {
        this.githubClient = githubClient;
    }

    @GetMapping(value = "/repos")
    public ResponseEntity<List<RepositoryResponse>> listMyRepositories(@RequestHeader(value = "token") String personalAccesToken) {

        var repos = githubClient.getRepositories(
                "bearer " + personalAccesToken,
                null,
                "public");

        return ResponseEntity.ok(repos);
    }
}
