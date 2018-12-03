package net.karlmartens;

import io.swagger.annotations.Api;
import jdk.nashorn.internal.objects.annotations.Getter;
import net.karlmartens.data.*;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Api
@Path("v1/namespaces")
@DenyAll
public class NamespaceV1Resource {

    @GET
    @Path("/list")
    @Produces(MediaType.TEXT_PLAIN)
    @PermitAll
    public String list() {
        return "karl,BP";
    }

    @POST
    @Path("/{namespace}/beginBatch")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("cdmWriter")
    public BeginBatchResponse beginBatch(@PathParam("namespace") String namespace) {
        BeginBatchResponse response = new BeginBatchResponse();
        response.batchId = "ABCDE";
        return response;
    }

    @POST
    @Path("/{namespace}/{batchId}:commit")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("cdmWriter")
    public BatchCommitResponse commitBatch(@PathParam("namespace") String namespace, @PathParam("batchId") String batchId, Batch batch) {
        final List<MutationResult> results = new ArrayList<>();
        for (Mutation m : batch.mutations) {
            m.visit(new MutationVisitor() {
                @Override
                public void onDelete(Delete d) {
                    MutationResult r = new MutationResult();
                    r.key = d._key;
                    r.version = 23;
                    results.add(r);
                }

                @Override
                public void onPut(Put p) {
                    MutationResult r = new MutationResult();
                    r.key = p.entity.key;
                    r.version = 12;
                    results.add(r);
                }
            });
        }
        return BatchCommitResponse.newInstance(results);
    }

    @DELETE
    @Path("/{namespace}/{batchId}")
    @RolesAllowed("cdmWriter")
    public Response cancelBatch(@PathParam("batchId") String batchId) {
        return Response.ok().build();
    }

    @GET
    @Path("/{namespace}/runQuery")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("cdmReader")
    public String runQuery(@PathParam("namespace") String namespace, String json) {
        return "{}";
    }

}
